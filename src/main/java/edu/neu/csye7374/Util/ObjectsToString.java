package edu.neu.csye7374.Util;

import java.text.SimpleDateFormat;
import java.util.List;

import edu.neu.csye7374.Booking;
import edu.neu.csye7374.Builder.*;
import edu.neu.csye7374.Interface.PersonAPI;
import edu.neu.csye7374.Interface.FlightAPI;

public class ObjectsToString {
	/*
	 * ObjectsToString is used to convert flight, customer and booking data into csv
	 * Strings
	 */
	public String FlightToString(FlightAPI flight) {
		StringBuilder flightBuilder = new StringBuilder();
		flightBuilder.append(String.valueOf(flight.getFlightID()) + ',');
		flightBuilder.append(String.valueOf(flight.getPrice()) + ',');
		flightBuilder.append(flight.getStartSite() + ',');
		flightBuilder.append(flight.getArriveSite() + ',');
		flightBuilder.append(new SimpleDateFormat("dd/MM/yyyy").format(flight.getFlightDate()));
		return flightBuilder.toString();
	}

	public FlightAPI StringToFlight(String flightData) {
		String[] flightDetails = flightData.split(",");
		FlightBuilder flightBuilder = new FlightBuilder();

		try {
			flightBuilder.setFlightID(Integer.valueOf(flightDetails[0]));
			flightBuilder.setPrice(Double.valueOf(flightDetails[1]));
			flightBuilder.setStartSite(flightDetails[2]);
			flightBuilder.setArriveSite(flightDetails[3]);
			flightBuilder.setFlightDate(new SimpleDateFormat("dd/MM/yyyy").parse(flightDetails[4]));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return flightBuilder.createFlight();
	}

	public String CustomerToString(PersonAPI person) {
		StringBuilder personBuilder = new StringBuilder();
		personBuilder.append(String.valueOf(person.getCustomerID()) + ',');
		personBuilder.append(person.getFirstName() + ',');
		personBuilder.append(person.getLastName() + ',');
		personBuilder.append(String.valueOf(person.getBirthYear()) + ',');
		personBuilder.append(String.valueOf(person.getBirthMonth()) + ',');
		personBuilder.append(String.valueOf(person.getBirthDay()));

		return personBuilder.toString();
	}

	public PersonAPI StringToCustomer(String personData) {
		String[] personDetails = personData.split(",");
		CustomerBuilder personBuilder = new CustomerBuilder();

		try {
			personBuilder.setCustomerID(Integer.valueOf(personDetails[0]));
			personBuilder.setFirstName(personDetails[1]);
			personBuilder.setLastName(personDetails[2]);
			personBuilder.setBirthYear(Integer.valueOf(personDetails[3]));
			personBuilder.setBirthMonth(Integer.valueOf(personDetails[4]));
			personBuilder.setBirthDay(Integer.valueOf(personDetails[5]));

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return personBuilder.createCustomers();
	}

	public String BookingToString(Booking booking) {
		StringBuilder bookingBuilder = new StringBuilder();
		bookingBuilder.append(String.valueOf(booking.getBookingId()) + ',');
		bookingBuilder.append(String.valueOf(booking.getFlight().getFlightID()) + ',');
		bookingBuilder.append(String.valueOf(booking.getCustomer().getCustomerID()));
		return bookingBuilder.toString();
	}

	public Booking StringToBooking(String bookingData, List<PersonAPI> personList, List<FlightAPI> flightList) {
		String[] bookingDetails = bookingData.split(",");
		Booking bookingObject = new Booking();
		try {
			bookingObject.setBookingId(Integer.valueOf(bookingDetails[0]));
			int personID = Integer.valueOf(bookingDetails[1]);
			int flightID = Integer.valueOf(bookingDetails[2]);
			PersonAPI matchedPerson = null;
			FlightAPI matchedFlight = null;

			for (PersonAPI person : personList) {
				if (person.getCustomerID() == personID) {
					matchedPerson = person;
					break;
				}
			}

			bookingObject.setCustomer(matchedPerson);
			for (FlightAPI flight : flightList) {
				if (flight.getFlightID() == flightID) {
					matchedFlight = flight;
					break;
				}
			}
			bookingObject.setFlight(matchedFlight);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return bookingObject;
	}
}
