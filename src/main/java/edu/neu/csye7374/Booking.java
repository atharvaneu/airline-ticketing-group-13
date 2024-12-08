package edu.neu.csye7374;
import edu.neu.csye7374.Bridge.TicketFeature;
import edu.neu.csye7374.Interface.*;
import edu.neu.csye7374.Observer.Observer;
//import edu.neu.csye7374.Prototype.AirlineTicket;
import edu.neu.csye7374.Prototype.TicketPrototype;

import java.util.ArrayList;
import java.util.List;

public class Booking implements TicketPrototype, Cloneable {
    private FlightAPI flight;
    private PersonAPI customer;
    private int bookingId;
    private String seatNumber;
    private String mealPreference;
    private List<Observer> observers = new ArrayList<>();
    private String status;
    private TicketFeature feature;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(String mealPreference) {
        this.mealPreference = mealPreference;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getStatus() {
        return status;
    }

    public void setFeature(TicketFeature feature) {
        this.feature = feature;
    }

    public void applyFeature() {
        if (feature != null) {
            feature.applyFeature(this);
        }
    }

    public FlightAPI getFlight() {
        return flight;
    }

    public Booking setFlight(FlightAPI flight) {
        this.flight = flight;
        return this;
    }

    public PersonAPI getCustomer() {
        return customer;
    }

    public Booking setCustomer(PersonAPI customer) {
        this.customer = customer;
        return this;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Booking setBookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public void bookTicket() {
        System.out.println(
                "Ticket booked for " + customer.getFirstName() + " " + customer.getLastName() + " on flight " + flight.getFlightID());
    }

    public void cancelTicket() {
        System.out.println(
                "Ticket canceled for " + customer.getFirstName() + " " + customer.getLastName() + " on flight " + flight.getFlightID());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.status);
        }
    }

    @Override
    public String toString() {
        StringBuilder sbForBooking = new StringBuilder();
        sbForBooking.append("Booking - " + bookingId + "\n");
        sbForBooking.append("Flight: " + flight.getFlightID() + "\n");
        sbForBooking.append("Customer Name: " + customer.getFirstName() + " " + customer.getLastName() + "\n");
        sbForBooking.append("Seat No: " + seatNumber + "\n");
        sbForBooking.append("Meal Preference: " + mealPreference + "\n");
        return sbForBooking.toString();
    }

    @Override
    public Booking cloneTicket() {
        try {
            return (Booking) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
