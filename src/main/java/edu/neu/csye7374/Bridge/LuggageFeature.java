package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;

public class LuggageFeature extends AbstractTicketFeature {
    private int additionalBags;
    private static final int MAX_ADDITIONAL_BAGS = 3;

    public LuggageFeature(int additionalBags) {
        super();
        this.additionalBags = additionalBags;
    }

    @Override
    protected void performFeatureApplication(Booking ticket) {
        int oldBags = ticket.getCheckedBags();
        ticket.setCheckedBags(oldBags + additionalBags);
        System.out.println(String.format(
                "Added %d additional bags for passenger %s %s. New total: %d bags",
                additionalBags,
                ticket.getCustomer().getFirstName(),
                ticket.getCustomer().getLastName(),
                ticket.getCheckedBags()
        ));
    }

    @Override
    public boolean validateFeature(Booking ticket) {
        return additionalBags > 0 &&
                additionalBags <= MAX_ADDITIONAL_BAGS &&
                (ticket.getCheckedBags() + additionalBags) <= MAX_ADDITIONAL_BAGS;
    }

    @Override
    public String getFeatureDescription() {
        return String.format("Additional Luggage (%d bags)", additionalBags);
    }
}