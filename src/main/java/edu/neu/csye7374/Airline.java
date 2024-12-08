package edu.neu.csye7374;

import java.util.List;

import edu.neu.csye7374.Facade.SaveAndLoadFacadeAPI;
import edu.neu.csye7374.Interface.*;

public class Airline {
    /*
     * AirLine class to represent and AirLine company
     * Contains Lists of flights, customers and bookings
     * Data persistence is managed via dataHandler of type SaveAndLoadFacadeAPI
     * loadData() and saveData() need to be used to load and save data respectively
     */
    public String airLineName = null;
    public SaveAndLoadFacadeAPI dataHandler;
    public List<FlightAPI> flights;
    public List<PersonAPI> customers;
    public List<Booking> bookings;
    public int customerCount, flightCount, bookingCount;
    public SaveAndLoadFacadeAPI getDataHandler() {
        return dataHandler;
    }
    public void setDataHandler(SaveAndLoadFacadeAPI dataHandler) {
        this.dataHandler = dataHandler;
        dataHandler.setAirLine(airLineName);
    }
    public List<FlightAPI> getFlights() {
        return flights;
    }
    public void setFlights(List<FlightAPI> flights) {
        this.flights = flights;
    }
    public List<PersonAPI> getCustomers() {
        return customers;
    }
    public void setCustomers(List<PersonAPI> customers) {
        this.customers = customers;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    public String getAirLineName() {
        return airLineName;
    }
    public void setAirlineName(String airLineName) {
        this.airLineName = airLineName;
    }
    public Airline() {
    }

    public void loadData() {
        flights = dataHandler.loadFlights();
        flightCount = flights.size();
        customers = dataHandler.loadCustomers();
        customerCount = customers.size();
        bookings = dataHandler.loadBookings(customers, flights);
        bookingCount = bookings.size();
    }

    public void saveData() {
        dataHandler.saveFlights(flights);
        dataHandler.saveCustomers(customers);
        dataHandler.saveBookings(bookings);
    }
    public void addFlight(FlightAPI flight) {
        flights.add(flight);
        flightCount = flights.size();
    }
    public void addCustomer(PersonAPI customer) {
        customers.add(customer);
        customerCount = customers.size();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        bookingCount = bookings.size();
    }

    public void saveFlights(List<FlightAPI> flights){
        for(FlightAPI flight : flights) {
            addFlight(flight);
        }
        dataHandler.saveFlights(this.flights);
    }

    public void saveCustomers(List<PersonAPI> customers){
        for(PersonAPI customer : customers) {
            addCustomer(customer);
        }
        dataHandler.saveCustomers(this.customers);
    }

    public void saveBooking(List<Booking> bookings){
        for(Booking booking : bookings) {
            addBooking(booking);
        }
        dataHandler.saveBookings(this.bookings);
    }

    @Override
    public String toString() {
        StringBuilder sbForAirline = new StringBuilder();
        sbForAirline.append("customers:");
        sbForAirline.append(customers);
        sbForAirline.append("flights:");
        sbForAirline.append(flights);
        sbForAirline.append("bookings:");
        sbForAirline.append(bookings);
        return sbForAirline.toString();
    }

}
