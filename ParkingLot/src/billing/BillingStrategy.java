package billing;

import models.ParkingTicket;

public interface BillingStrategy {
    double calculateAmount(ParkingTicket ticket);
}
