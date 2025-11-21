import billing.BillingStrategy;
import billing.HourlyBillingStrategy;
import billing.ProgressiveBillingStrategy;
import models.*;

public class Main {
    public static void main(String[] args) {

        // ------------------------------------
        // 1. CREATE PARKING LOT
        // ------------------------------------
        ParkingLot parkingLot = new ParkingLot(
                2,    // numLevels
                5,    // small spots per level
                5,    // medium spots per level
                5     // large spots per level
        );

        System.out.println("=== Parking Lot Created ===");

        // ------------------------------------
        // 2. CREATE BILLING STRATEGIES
        // ------------------------------------
        BillingStrategy hourlyBilling = new HourlyBillingStrategy(50.0);    // ₹50/hour
        BillingStrategy progressiveBilling = new ProgressiveBillingStrategy(40.0, 20.0);

        // ------------------------------------
        // 3. CREATE VEHICLES
        // ------------------------------------
        Vehicle car = new Car("GJ05AB1234");
        Vehicle bike = new Bike("MH12XY9988");

        // ------------------------------------
        // 4. PARK VEHICLES
        // ------------------------------------
        System.out.println("\n=== Parking vehicles ===");

        ParkingTicket carTicket = parkingLot.parkVehicle(car)
                ? new ParkingTicket(car, hourlyBilling)
                : null;

        ParkingTicket bikeTicket = parkingLot.parkVehicle(bike)
                ? new ParkingTicket(bike, progressiveBilling)
                : null;

        System.out.println("Car parked?   " + (carTicket != null));
        System.out.println("Bike parked?  " + (bikeTicket != null));

        // ------------------------------------
        // 5. PRINT SPOT AVAILABILITY
        // ------------------------------------
        System.out.println("\n=== Availability After Parking ===");
        parkingLot.printAvailability();

        // Simulate delay so billing has something to calculate
        try { Thread.sleep(2000); } catch (Exception ignored) {}

        // ------------------------------------
        // 6. REMOVE VEHICLES (EXIT FLOW)
        // ------------------------------------
        System.out.println("\n=== Removing Vehicles ===");

        System.out.println("Car fee: " + carTicket.calculateFee());
        parkingLot.removeVehicle(carTicket);

        System.out.println("Bike fee: " + bikeTicket.calculateFee());
        parkingLot.removeVehicle(bikeTicket);

        // ------------------------------------
        // 7. FINAL AVAILABILITY
        // ------------------------------------
        System.out.println("\n=== Final Availability After Exit ===");
        parkingLot.printAvailability();
    }
}

