package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;
import java.util.HashSet;
import java.util.Set;

public class SeatChangeFeature extends AbstractTicketFeature {
    private String newSeatId;
    private static final Set<String> RESTRICTED_SEATS = new HashSet<>();

    static {
        // Initialize restricted seats (e.g., emergency exits requiring special eligibility)
        RESTRICTED_SEATS.add("EXIT1");
        RESTRICTED_SEATS.add("EXIT2");
    }

    public SeatChangeFeature(String newSeatId) {
        super();
        this.newSeatId = newSeatId;
    }

    @Override
    protected void performFeatureApplication(Booking ticket) {
        String oldSeat = ticket.getSeatNumber();
        ticket.setSeatNumber(newSeatId);
        System.out.println(String.format(
                "Seat changed from %s to %s for passenger %s %s",
                oldSeat,
                newSeatId,
                ticket.getCustomer().getFirstName(),
                ticket.getCustomer().getLastName()
        ));
    }

    @Override
    public boolean validateFeature(Booking ticket) {
        // Validate seat change is allowed
        if (RESTRICTED_SEATS.contains(newSeatId)) {
            return false;
        }
        return !newSeatId.equals(ticket.getSeatNumber());
    }

    @Override
    public String getFeatureDescription() {
        return "Seat Change to " + newSeatId;
    }
}