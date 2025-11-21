package models;

import billing.BillingStrategy;
import billing.HourlyBillingStrategy;

public class ParkingTicket {
    private Vehicle vehicle;
    private ParkingSpot spot;
    private Level level;
    private long entryTime;
    private BillingStrategy billingStrategy;


    public ParkingTicket(Vehicle vehicle, ParkingSpot spot, Level level) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.level = level;
        this.entryTime = System.currentTimeMillis();
        this.billingStrategy = new HourlyBillingStrategy(5.0); // Default strategy
    }
    public Vehicle getVehicle() { return vehicle; }
    public Level getLevel() { return level; }
    public ParkingSpot getSpot() { return spot; }
    public long getEntryTime() { return entryTime; }

    public void calculateFee() {
        double amount = this.billingStrategy.calculateAmount(this);
        System.out.println("Parking fee for vehicle " + vehicle.getLicensePlate() + ": $" + amount);
    }
}
