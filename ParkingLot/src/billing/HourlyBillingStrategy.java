package billing;

import models.ParkingTicket;

public class HourlyBillingStrategy implements BillingStrategy {

    private double hourlyRate;

    public HourlyBillingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateAmount(ParkingTicket ticket) {
        long currentTime = System.currentTimeMillis();
        long durationInMillis = currentTime - ticket.getEntryTime();
        double hoursParked = Math.ceil(durationInMillis / (1000.0 * 60 * 60));
        return hoursParked * hourlyRate;
    }
}
