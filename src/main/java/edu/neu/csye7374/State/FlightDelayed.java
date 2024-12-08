package edu.neu.csye7374.State;

public class FlightDelayed implements FlightStateAPI{
    public static FlightState flightState;

    public FlightDelayed(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        flightState.setState(flightState.getFlightOnBoarding());
        System.out.println("Apologies for the delay\n FlightID: "+ flightState.getFlightID() + " is now On Boarding.");
    }

    @Override
    public void inTransit() {
        System.out.println("ERROR: Cannot change to 'In Transit' state. Flight is Delayed.");
    }

    @Override
    public void delay() {
        System.out.println("Flight" + flightState.getFlightID() + " is already Delayed.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        System.out.println("Flight - "+ flightState.getFlightID() + " is Cancelled.");
    }

    @Override
    public void offboarding() {
        flightState.setState(flightState.getOffBoarding());
        System.out.println("Apologies for the delay\n Flight - "+flightState.getFlightID() +" is now Off Boarding.");
    }
}
