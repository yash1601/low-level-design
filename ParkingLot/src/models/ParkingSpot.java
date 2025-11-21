package models;

class ParkingSpot {
    private String spotId;
    private VehicleType size;
    private boolean isFree;
    Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleType size) {
        this.spotId = spotId;
        this.size = size;
        this.isFree = true;
        this.parkedVehicle = null;
    }

    public boolean isFree() { return isFree; }
    public VehicleType getSize() { return size; }
    public String getSpotId() { return spotId; }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isFree = false;
    }
    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isFree = true;
    }
}
