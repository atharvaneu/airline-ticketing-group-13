package edu.neu.csye7374.State;

public class FlightOffBoarding implements FlightStateAPI{
    public static FlightState flightState;

    public FlightOffBoarding(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        flightState.setState(flightState.getFlightOnBoarding());
        System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is Off Boarding.");
    }

    @Override
    public void inTransit() {
        System.out.println("ERROR: Cannot change to 'In Transit' state. Flight is Off Boarding.");
    }

    @Override
    public void delay() {
        System.out.println("ERROR: Cannot change to 'Delayed' state. Flight is Off Boarding.");
    }

    @Override
    public void cancelled() {
        System.out.println("ERROR: Cannot change to 'Cancelled' state. Flight is Off Boarding.");
    }

    @Override
    public void offboarding() {
        System.out.println("Flight - "+ flightState.getFlightID()+" is already Off Boarding.");
    }
}
