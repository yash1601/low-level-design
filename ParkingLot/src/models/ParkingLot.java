package models;

import java.util.List;

public class ParkingLot {
    private List<Level> levels;

    public ParkingLot(int numLevels, int smallPerLevel, int medPerLevel, int largePerLevel) {
        this.levels = new java.util.ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            this.levels.add(new Level(i, smallPerLevel, medPerLevel, largePerLevel));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked at level " + level);
                return true;
            }
        }
        System.out.println("Parking Full for vehicle " + vehicle.getLicensePlate());
        return false;
    }
    public void removeVehicle(ParkingTicket ticket) {
        ticket.getLevel().removeVehicle(ticket);
        ticket.calculateFee();
    }
    public void printAvailability() {
        for (int i = 0; i < levels.size(); i++) {
            Level level = levels.get(i);
            System.out.println("Level " + i + " availability: " + level.getAvailableSpots());
        }
    }
}
