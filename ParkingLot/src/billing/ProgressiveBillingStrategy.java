package billing;

import models.ParkingTicket;

public class ProgressiveBillingStrategy implements BillingStrategy {

    private double baseRate;
    private double additionalRate;

    public ProgressiveBillingStrategy(double baseRate, double additionalRate) {
        this.baseRate = baseRate;
        this.additionalRate = additionalRate;
    }

    @Override
    public double calculateAmount(ParkingTicket ticket) {
        // 1st hour = X, after that = Y)
        long currentTime = System.currentTimeMillis();
        long durationInMillis = currentTime - ticket.getEntryTime();
        double hoursParked = Math.ceil(durationInMillis / (1000.0 * 60 * 60));
        if (hoursParked <= 1) {
            return baseRate;
        } else {
            return baseRate + (hoursParked - 1) * additionalRate;
        }
    }
}
