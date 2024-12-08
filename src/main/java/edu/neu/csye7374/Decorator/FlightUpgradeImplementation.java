package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Booking;

public class FlightUpgradeImplementation implements FlightUpgradeOptions {
    Booking booking;
    public FlightUpgradeImplementation(Booking booking) {
        super();
        this.booking = booking;
    }
    @Override
    public double getBasePrice() {
        return this.booking.getFlight().getPrice();
    }
    @Override
    public String getUpgradeDescription() {
        return "Flight Upgrade";
    }
}
