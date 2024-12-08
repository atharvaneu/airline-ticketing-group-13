package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;

public class SeatChangeFeature implements TicketFeature {

    public SeatChangeFeature(String seatID) {
        this.seatID = seatID;
    }

    @Override
    public void applyFeature(Booking ticket) {
        System.out.println("Applying seat change: " + seatID + " to ticket for " + ticket.getSeatNumber());
        ticket.setSeatNumber(seatID);
    }

    private String seatID;
}
