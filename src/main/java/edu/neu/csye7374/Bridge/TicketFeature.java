package edu.neu.csye7374.Bridge;
import edu.neu.csye7374.Booking;
import edu.neu.csye7374.Prototype.TicketPrototype;

public interface TicketFeature {
    /**
     * Apply a feature a.k.a flip this.isApplied to true and add to list of applied features
     * @param ticket
     */
    void applyFeature(Booking ticket);

    /**
     * Validate if a feature can be applied based on the airline/airport policy
     * @param ticket
     * @return
     */
    boolean validateFeature(Booking ticket);

    /**
     * Get a feature's description
     * @return
     */
    String getFeatureDescription();
}
