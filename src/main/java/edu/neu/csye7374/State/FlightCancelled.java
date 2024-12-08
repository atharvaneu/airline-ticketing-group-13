package edu.neu.csye7374.State;

public class FlightCancelled implements FlightStateAPI{
    public static FlightState flightState;

    public FlightCancelled(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is Cancelled.");
    }

    @Override
    public void inTransit() {
        System.out.println("ERROR: Cannot change to 'In Transit' state. Flight is Cancelled.");
    }

    @Override
    public void delay() {
        System.out.println("ERROR: Cannot change to 'Delayed' state. Flight is Cancelled.");
    }

    @Override
    public void cancelled() {
        System.out.println("Flight is already Cancelled.");
    }

    @Override
    public void offboarding() {
        System.out.println("ERROR: Cannot change to 'Off Boarding' state. Flight is Cancelled.");
    }
}
