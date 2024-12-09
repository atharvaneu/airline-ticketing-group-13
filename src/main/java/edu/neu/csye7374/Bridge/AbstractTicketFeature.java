package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;
import java.time.LocalDateTime;

public abstract class AbstractTicketFeature implements TicketFeature {
    protected LocalDateTime applicationTime;
    protected boolean isApplied;

    public AbstractTicketFeature() {
        this.isApplied = false;
    }

    @Override
    public void applyFeature(Booking ticket) {
        if (validateFeature(ticket)) {
            performFeatureApplication(ticket);
            this.applicationTime = LocalDateTime.now();
            this.isApplied = true;
            logFeatureApplication(ticket);
        } else {
            throw new IllegalStateException("Feature validation failed for ticket: " + ticket.getBookingId());
        }
    }

    protected abstract void performFeatureApplication(Booking ticket);

    protected void logFeatureApplication(Booking ticket) {
        System.out.println(String.format(
                "Feature %s applied to ticket %s at %s",
                getFeatureDescription(),
                ticket.getBookingId(),
                applicationTime
        ));
    }

    public boolean isFeatureApplied() {
        return isApplied;
    }
}
