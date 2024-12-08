package edu.neu.csye7374;

import edu.neu.csye7374.Decorator.*;
import edu.neu.csye7374.Facade.SaveAndLoadFacadeAPI;
import edu.neu.csye7374.Facade.SaveAndLoadToLocal;
import edu.neu.csye7374.Factory.*;
import edu.neu.csye7374.Interface.*;
import edu.neu.csye7374.Observer.EmailObserver;
import edu.neu.csye7374.Observer.SMSObserver;
//import edu.neu.csye7374.Prototype.AirlineTicket;
import edu.neu.csye7374.Builder.*;
import edu.neu.csye7374.Command.BookTicketCommand;
import edu.neu.csye7374.Command.CancelTicketCommand;
import edu.neu.csye7374.Command.Command;
import edu.neu.csye7374.Command.TicketInvoker;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.State.*;
import edu.neu.csye7374.Adapter.*;
import edu.neu.csye7374.Bridge.MealPreferenceFeature;
import edu.neu.csye7374.Bridge.SeatChangeFeature;
import edu.neu.csye7374.Bridge.TicketFeature;
import edu.neu.csye7374.Util.CSVHandler;
import edu.neu.csye7374.Util.FileHandlerAPI;
import edu.neu.csye7374.Observer.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
        /*
         * contains only static demo() method to showcase all design patterns and
         * intended program workflow
         * console output reflects working of the demo() method
         */
        public static void demo() throws ParseException {

                // Singleton Factory Design Pattern
                System.out.println("\n******************* Singleton Factory Design Pattern *******************\n");

                System.out.println("Creating airline using Singleton Factory...");
                AirlineFactory airlineFactory2 = AirlineFactory.getInstance();
                Airline Delta = airlineFactory2.getObject();
                Delta.setAirlineName("Delta");
                System.out.println("Airline created: " + Delta.getAirLineName());

                System.out.println("\nSingleton Factory pattern ensures a class has only one instance and provides a global point of access to it.");
                System.out.println("\n************************************************************** ");

                // Facade Design Pattern
                System.out.println("\n******************* Facade Design Pattern *******************\n");

                FileHandlerAPI csvHandler = new CSVHandler();
                SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);

                System.out.println("Creating Delta airways using Facade pattern...");

                // Set data handler for the airline
                Delta.setDataHandler(dataHandler);

                // Load data using facade pattern
                Delta.loadData();
                System.out.println("Delta Airline Data loaded successfully.");

                System.out.println("\nFacade pattern simplifies the interaction with complex subsystems by providing a unified interface.");
                System.out.println("\n************************************************************** ");

                // Builder Design Pattern
                System.out.println("\n******************* Builder Design Pattern *******************\n");

                Date date = new SimpleDateFormat("MM-dd-yyyy").parse("12-01-2022");
                List<FlightAPI> flightList = new ArrayList<>();
                flightList.add(new FlightBuilder()
                        .setFlightID(4)
                        .setFlightDate(date)
                        .setPrice(3000)
                        .setStartSite("Boston")
                        .setArriveSite("Iceland")
                        .createFlight());

                flightList.add(new FlightBuilder()
                        .setFlightID(5)
                        .setFlightDate(date)
                        .setPrice(1200)
                        .setStartSite("New York")
                        .setArriveSite("Paris")
                        .createFlight());

                List<PersonAPI> customersList = new ArrayList<>();
                customersList.add(new CustomerBuilder()
                        .setCustomerID(4)
                        .setFirstName("Ameya")
                        .setLastName("Apte")
                        .setBirthYear(1997)
                        .setBirthMonth(10)
                        .setBirthDay(28)
                        .createCustomers());

                customersList.add(new CustomerBuilder()
                        .setCustomerID(5)
                        .setFirstName("Kunal")
                        .setLastName("Thapa")
                        .setBirthYear(1996)
                        .setBirthMonth(12)
                        .setBirthDay(02)
                        .createCustomers());

                customersList.add(new CustomerBuilder()
                        .setCustomerID(6)
                        .setFirstName("Sayeed")
                        .setLastName("Ahmed")
                        .setBirthYear(1998)
                        .setBirthMonth(06)
                        .setBirthDay(12)
                        .createCustomers());

                System.out.println("Customer data top row: \n" + customersList.get(0));
                System.out.println("Flight data top row: \n" + flightList.get(0));



                System.out.println("Flights and Customers created using Builder pattern.");
                System.out.println("\nBuilder pattern provides a step-by-step approach to construct complex objects.");
                System.out.println("\n************************************************************** ");

                // Save data using Facade Pattern
                System.out.println("\n******************* Save Data using Facade Pattern *******************\n");

                Delta.saveFlights(flightList);
                Delta.saveCustomers(customersList);

                System.out.println("Data saved at: " + Delta.getAirLineName() + "Flight.csv and " + Delta.getAirLineName() + "Customer.csv");

                System.out.println("Data saved successfully using Facade pattern.");

                System.out.println("\n************************************************************** ");


                // Strategy Design Pattern
                System.out.println("\n******************* Strategy Design Pattern *******************\n");

                // Available Discounts and Promo
                DiscountStrategyAPI veteranDiscount = new VeteranDiscountStrategy();
                DiscountStrategyAPI summerPromo = new SummerPromoStrategy();
                DiscountStrategyAPI christmasDiscount = new ChristmasDiscountStrategy();

                System.out.println("Available Offers and Discounts are:");
                System.out.println(veteranDiscount);
                System.out.println(summerPromo);
                System.out.println(christmasDiscount);

                // Apply discounts
                FlightAPI flight = Delta.getFlights().get(0);
                System.out.println("Initial Price of flight: $" + flight.getPrice());

                flight.setPrice(christmasDiscount.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Christmas Discount: $" + flight.getPrice());

                flight.setPrice(summerPromo.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Summer Discount: $" + flight.getPrice());

                flight.setPrice(veteranDiscount.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Veteran's Discount: $" + flight.getPrice());

                System.out.println("\nStrategy pattern allows for the definition of a family of algorithms, encapsulating each one, and making them interchangeable.");
                System.out.println("\n************************************************************** ");

                // Decorator Design Pattern
                System.out.println("\n******************* Decorator Design Pattern *******************\n");

                Booking booking = new Booking();
                booking.setFlight(Delta.getFlights().get(1));
                booking.setCustomer(Delta.getCustomers().get(0));
                booking.setBookingId(4);
                booking.setSeatNumber("12A");
                booking.getFlight().setPrice(500.0);

                System.out.println("Initial booking details: \n" + booking);
                System.out.println("Initial booking price: $" + booking.getFlight().getPrice());

                // Adding upgrades using Decorator pattern
                FlightUpgradeOptions upgradedBooking = new PremiumUpgrade(new FlightUpgradeImplementation(booking));
                System.out.println("After adding premium upgrade: " + upgradedBooking.getUpgradeDescription());
                System.out.println("Price after adding premium upgrade: $" + upgradedBooking.getBasePrice());

                System.out.println("\nDecorator pattern allows behavior to be added to individual objects, dynamically.");
                System.out.println("\n************************************************************** ");

                // Bridge Design Pattern
                System.out.println("\n******************* Bridge Design Pattern *******************\n");

                // Apply seat selection feature
                TicketFeature seatSelection = new SeatChangeFeature("13D");
                booking.setFeature(seatSelection);
                booking.applyFeature();

                // Apply meal preference feature
                TicketFeature mealPreference = new MealPreferenceFeature("Vegetarian");
                booking.setFeature(mealPreference);
                booking.applyFeature();

                // Display final ticket details
                System.out.println("Final Ticket Details: ");
                System.out.println("Passenger: " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName());
                System.out.println("Flight: " + booking.getFlight().getFlightID());
                System.out.println("Seat: " + booking.getSeatNumber());
                System.out.println("Meal: " + booking.getMealPreference());

                System.out.println("\nBridge pattern separates the abstraction from its implementation, allowing for flexible extensions.");
                System.out.println("\n************************************************************** ");


                // Prototype Design Pattern
                System.out.println("\n******************* Prototype Design Pattern *******************\n");

                // Clone the ticket for another passenger

                Booking clonedBooking = (Booking) booking.cloneTicket();
//                System.out.println(clonedBooking);
                clonedBooking.setCustomer(Delta.getCustomers().get(1));
                clonedBooking.setSeatNumber("14B");



                // Print out both tickets
                System.out.println("Original Ticket: " + booking);
                System.out.println("Cloned Ticket: " + clonedBooking);
                System.out.println("\nPrototype pattern allows for creating a duplicate object with minimal effort.");
                System.out.println("\n************************************************************** ");


                // Command Design Pattern
                System.out.println("\n******************* Command Design Pattern *******************\n");

                // Create commands
                Command bookCommand = new BookTicketCommand(clonedBooking);
                Command cancelCommand = new CancelTicketCommand(clonedBooking);

                // Create the invoker
                TicketInvoker invoker = new TicketInvoker();

                // Book a ticket
                invoker.setCommand(bookCommand);
                invoker.executeCommand();

                // Cancel the ticket
                invoker.setCommand(cancelCommand);
                invoker.executeCommand();

                System.out.println("\nCommand pattern decouples the sender and receiver by encapsulating requests as objects.");
                System.out.println("\n************************************************************** ");

                // Observer Design Pattern
                System.out.println("\n******************* Observer Design Pattern *******************\n");

                Observer emailObserver = new EmailObserver();
                Observer smsObserver = new SMSObserver();

                // Attach observers to the ticket
                booking.addObserver(emailObserver);
                booking.addObserver(smsObserver);

                // Change ticket status and notify observers
                booking.setStatus("Booked");
                booking.setStatus("Checked-In");
                booking.setStatus("Canceled");

                System.out.println("\nObserver pattern enables an object to notify its observers of state changes, allowing for a one-to-many relationship.");
                System.out.println("\n************************************************************** ");


                // Adapter Design Pattern
                System.out.println("\n******************* Adapter Design Pattern *******************\n");
//
                USCurrency us_currency = new USCurrency();
                FlightPriceCurrency Ifpc = new INRCurrency();
                FlightPriceCurrency Cfpc = new CanadaCurrency();

                FlightPriceCurrency c_adapter = new CurrencyAdapter(us_currency);

                System.out.println("US Currency...LegacyAPI");
                us_currency.showPriceCurrency(Delta.getFlights().get(0).getPrice());

                System.out.println("Flight Price in INR Currency...Client API");
                Ifpc.showcurrency(Delta.getFlights().get(0).getPrice());

                System.out.println("Flight Price in Canadian Dollar Currency...Client API");
                Cfpc.showcurrency(Delta.getFlights().get(0).getPrice());

                System.out.println("CurrencyAdapter...adapter over Legacy API");
                c_adapter.showcurrency(Delta.getFlights().get(0).getPrice());


                System.out.println("\nAdapter pattern allows objects with incompatible interfaces to work together.");
                System.out.println("\n************************************************************** ");

                System.out.println("\n******************* State Design Pattern *******************\n");

                FlightState fs = new FlightState(Delta.getFlights().get(0).getFlightID());
                fs.onBoarding();
                //
                fs.delay();
                fs.offboarding();
                fs.onBoarding();
                //
                fs.inTransit();
                fs.onBoarding();
                //
                fs.inTransit();
                fs.delay();
                //
                fs.offboarding();

                fs.onBoarding();
                fs.inTransit();
                fs.delay();
                fs.cancelled();
                fs.offboarding();

                FlightState fs2 = new FlightState(Delta.getFlights().get(1).getFlightID());
                fs2.delay();
                fs2.onBoarding();
                fs2.cancelled();
                fs2.inTransit();
                System.out.println("Flight Schedule status: " + fs2.isScheduled());

                System.out.println("\nState pattern allows an object to change its behavior when its internal state changes.");
                System.out.println("\n************************************************************** ");


        }
}
