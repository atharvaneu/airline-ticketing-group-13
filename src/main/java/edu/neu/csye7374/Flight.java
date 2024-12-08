package edu.neu.csye7374;

import java.util.Date;
import edu.neu.csye7374.Interface.FlightAPI;
import edu.neu.csye7374.Builder.FlightBuilder;

public class Flight implements FlightAPI{
    private int flightID;
    private double price;
    private Date flightDate;
    private String startSite;
    private String arriveSite;
    public Flight(FlightBuilder fb) {
        this.flightID = fb.getFlightID();
        this.price = fb.getPrice();
        this.flightDate = fb.getFlightDate();
        this.startSite = fb.getStartSite();
        this.arriveSite = fb.getArriveSite();
    }

    public int getFlightID() {
        return flightID;
    }

    public double getPrice() {
        return price;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getStartSite() {
        return startSite;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flight - "+ flightID + "\n");
        sb.append("Price: " + price + "\n");
        sb.append("Date: " + flightDate + "\n");
        sb.append("Origin: " + startSite + "\n");
        sb.append("Destination: " + arriveSite + "\n");
        return sb.toString();
    }

}
