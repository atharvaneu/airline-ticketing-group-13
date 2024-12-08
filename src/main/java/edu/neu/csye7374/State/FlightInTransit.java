package edu.neu.csye7374.State;

public class FlightInTransit implements FlightStateAPI{
    public static FlightState flightState;

    public FlightInTransit(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is already In Transit.");
    }

    @Override
    public void inTransit() {
        System.out.println("FLight - " +flightState.getFlightID() + " Already in Transit!");
    }

    @Override
    public void delay() {
        System.out.println("ERROR: Cannot change to 'Delayed' state. Flight is In Transit.");
    }

    @Override
    public void cancelled() {
        System.out.println("ERROR: Cannot change to 'Cancelled' state. Flight is In Transit.");
    }


    @Override
    public void offboarding() {
        flightState.setState(flightState.getOffBoarding());
        System.out.println("Flight - "+ flightState.getFlightID()+" is offBoarding.");
    }
}
