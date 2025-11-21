package models;


import java.util.List;
import java.util.Map;

class Level {
    private int levelNumber;
    private int availableSmallSpots;
    private int availableMediumSpots;
    private int availableLargeSpots;
    private List<ParkingSpot> smallSpots;
    private List<ParkingSpot> mediumSpots;
    private List<ParkingSpot> largeSpots;
    Map<VehicleType, Integer> availability = new java.util.HashMap<>();

    public Level(int levelNumber, int smallCount, int mediumCount, int largeCount) {
        this.levelNumber = levelNumber;
        this.availableLargeSpots = largeCount;
        this.availableMediumSpots = mediumCount;
        this.availableSmallSpots = smallCount;
        this.smallSpots = new java.util.ArrayList<>();
        this.mediumSpots = new java.util.ArrayList<>();
        this.largeSpots = new java.util.ArrayList<>();
        for(int i = 0; i < smallCount; i++) {
            smallSpots.add(new ParkingSpot("S" + i, VehicleType.BIKE));
        }
        for(int i = 0; i < mediumCount; i++) {
            mediumSpots.add(new ParkingSpot("M" + i, VehicleType.CAR));
        }
        for(int i = 0; i < largeCount; i++) {
            largeSpots.add(new ParkingSpot("L" + i, VehicleType.TRUCK));
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle, VehicleType vehicleType) {
        if(vehicleType == VehicleType.BIKE){
            for(ParkingSpot spot : smallSpots){
                if(spot.isFree()){
                    return spot;
                }
            }
        } else if(vehicleType == VehicleType.CAR){
            for(ParkingSpot spot : mediumSpots){
                if(spot.isFree()){
                    return spot;
                }
            }
        } else if(vehicleType == VehicleType.TRUCK){
            for(ParkingSpot spot : largeSpots){
                if(spot.isFree()){
                    return spot;
                }
            }
        }
        return null;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        VehicleType v = vehicle.getType();
        if(v == VehicleType.BIKE){
            if(availableSmallSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.BIKE);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableSmallSpots--;
                return true;
            } else if(availableMediumSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.CAR);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableMediumSpots--;
                return true;
            } else if(availableLargeSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.TRUCK);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableLargeSpots--;
                return true;
            }
        }
        else if(v == VehicleType.CAR){
            if(availableMediumSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.CAR);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableMediumSpots--;
                return true;
            } else if(availableLargeSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.TRUCK);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableLargeSpots--;
                return true;
            }
        }
        else if(v == VehicleType.TRUCK){
            if(availableLargeSpots > 0){
                ParkingSpot spot = findAvailableSpot(vehicle, VehicleType.TRUCK);
                if(spot == null) return false;
                spot.parkVehicle(vehicle);
                availableLargeSpots--;
                return true;
            }
        }
        return false;
    }
    public void removeVehicle(ParkingTicket parkingTicket) {
        ParkingSpot spot = parkingTicket.getSpot();
        VehicleType v = spot.getSize();
        spot.removeVehicle();
        if(v == VehicleType.BIKE){
            availableSmallSpots++;
        } else if(v == VehicleType.CAR){
            availableMediumSpots++;
        } else if(v == VehicleType.TRUCK){
            availableLargeSpots++;
        }
    }

    public Map<VehicleType, Integer> getAvailableSpots() {
        availability.put(VehicleType.BIKE, availableSmallSpots);
        availability.put(VehicleType.CAR, availableMediumSpots);
        availability.put(VehicleType.TRUCK, availableLargeSpots);
        return availability;
    }
}
