package edu.neu.csye7374.State;

public class FlightOnBoarding implements FlightStateAPI{
    public static FlightState flightState;

    public FlightOnBoarding(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("FlightID: "+ flightState.getFlightID()+" is already On Boarding.");
    }

    @Override
    public void inTransit() {
        flightState.setState(flightState.getInTransit());
        System.out.println("FlightID: "+ flightState.getFlightID()+" is now In Transit.");
    }

    @Override
    public void delay() {
        flightState.setState(flightState.getDelayed());
        System.out.println("Cannot on board as flight - "+ flightState.getFlightID()+" is currently Delayed.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        System.out.println("Connont on board as flight - "+ flightState.getFlightID()+" is Cancelled.");
    }


    @Override
    public void offboarding() {
        System.out.println("ERROR: Cannot change to 'Off Boarding' state. Flight is On Boarding.");
    }
}
