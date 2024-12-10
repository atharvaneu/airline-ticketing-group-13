package edu.neu.csye7374;

import edu.neu.csye7374.Bridge.LuggageFeature;
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
        public static void run() throws ParseException {

                // Design Pattern 1- Singleton Factory Design Pattern
                System.out.println("\n*********** DESIGN PATTERN - Singleton Factory Design Pattern **********\n");

                System.out.println("Initialize Airline though Singleton Factory...");
                AirlineFactory af = AirlineFactory.getInstance();
                Airline Emirates = af.getObject();
                Emirates.setAirlineName("Emirates");
                System.out.println("Airline created: " + Emirates.getAirLineName());

                System.out.println("\nThe Singleton Factory pattern ensures a single factory instance globally manages object creation and control.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 2 - Facade Design Pattern
                System.out.println("\n************ DESIGN PATTERN - Facade Design Pattern *************\n");

                FileHandlerAPI csvHandler = new CSVHandler();
                SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);

                System.out.println("Initializing Emirates Airlines using Facade design pattern...");

                // Set data handler for the airline
                Emirates.setDataHandler(dataHandler);

                // Load data using facade pattern
                Emirates.loadData();
                System.out.println("Emirates Airline Data loaded successfully.");

                System.out.println("\nThe Facade design pattern provides a simplified, unified interface to a complex subsystem, making it easier to use.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 3 - Builder Design Pattern
                System.out.println("\n************ DESIGN PATTERN - Builder Design Pattern **************\n");

                Date date = new SimpleDateFormat("MM-dd-yyyy").parse("12-06-2024");
                List<FlightAPI> flightList = new ArrayList<>();
                flightList.add(new FlightBuilder()
                        .setFlightID(4)
                        .setFlightDate(date)
                        .setPrice(3000)
                        .setStartSite("Boston")
                        .setArriveSite("New York")
                        .createFlight());

                flightList.add(new FlightBuilder()
                        .setFlightID(5)
                        .setFlightDate(date)
                        .setPrice(1200)
                        .setStartSite("Newark")
                        .setArriveSite("India")
                        .createFlight());

                List<PersonAPI> customersList = new ArrayList<>();
                customersList.add(new CustomerBuilder()
                        .setCustomerID(4)
                        .setFirstName("Nishi")
                        .setLastName("Pancholi")
                        .setBirthYear(1997)
                        .setBirthMonth(10)
                        .setBirthDay(28)
                        .createCustomers());

                customersList.add(new CustomerBuilder()
                        .setCustomerID(5)
                        .setFirstName("Andrea")
                        .setLastName("Sequeria")
                        .setBirthYear(1996)
                        .setBirthMonth(12)
                        .setBirthDay(02)
                        .createCustomers());

                customersList.add(new CustomerBuilder()
                        .setCustomerID(6)
                        .setFirstName("Atharva")
                        .setLastName("Kamble")
                        .setBirthYear(1998)
                        .setBirthMonth(06)
                        .setBirthDay(12)
                        .createCustomers());

                System.out.println("Customer's Row: \n" + customersList.get(0));
                System.out.println("Flight's Row: \n" + flightList.get(0));



                System.out.println("Flights and Customers created using Builder pattern complete.");
                System.out.println("\nThe Builder pattern simplifies complex object creation by constructing it step-by-step through a controlled process.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 4- Save data using Facade Pattern
                System.out.println("\n************* DESIGN PATTERN - Save Data using Facade Pattern ***************\n");

                Emirates.saveFlights(flightList);
                Emirates.saveCustomers(customersList);

                System.out.println("Data saved at: " + Emirates.getAirLineName() + "Flight.csv and " + Emirates.getAirLineName() + "Customer.csv");

                System.out.println("Data saved successfully using Facade pattern into the own csv file.");

                System.out.println("\n************************************************************** ");


                // Design Pattern 5- Strategy Design Pattern
                System.out.println("\n*********** DESIGN PATTERN - Strategy Design Pattern *************\n");

                // Available Discounts and Promo
                DiscountStrategyAPI veteranDiscount = new VeteranDiscountStrategy();
                DiscountStrategyAPI summerPromo = new SummerPromoStrategy();
                DiscountStrategyAPI christmasDiscount = new ChristmasDiscountStrategy();

                System.out.println("Current Offers and Promotions eligible:");
                System.out.println(veteranDiscount);
                System.out.println(summerPromo);
                System.out.println(christmasDiscount);

                // Apply discounts
                FlightAPI flight = Emirates.getFlights().get(0);
                System.out.println("Flight Price Before Discount: $" + flight.getPrice());

                flight.setPrice(christmasDiscount.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Christmas Discount: $" + flight.getPrice());

                flight.setPrice(summerPromo.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Summer Discount: $" + flight.getPrice());

                flight.setPrice(veteranDiscount.CalculateDiscount(flight.getPrice()));
                System.out.println("Price after applying Veteran's Discount: $" + flight.getPrice());

                System.out.println("\nThe Strategy pattern defines a family of algorithms, encapsulates them, and allows their interchangeability at runtime.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 6 - Decorator Design Pattern
                System.out.println("\n************DESIGN PATTERN - Decorator Design Pattern *************\n");

                Booking booking = new Booking();
                booking.setFlight(Emirates.getFlights().get(1));
                booking.setCustomer(Emirates.getCustomers().get(0));
                booking.setBookingId(4);
                booking.setSeatNumber("25B");
                booking.getFlight().setPrice(500.0);

                System.out.println("Initial booking details: \n" + booking);
                System.out.println("Initial booking price: $" + booking.getFlight().getPrice());

                // Adding upgrades using Decorator pattern
                FlightUpgradeOptions upgradedBooking = new PremiumUpgrade(new FlightUpgradeImplementation(booking));
                System.out.println("After adding premium upgrade: " + upgradedBooking.getUpgradeDescription());
                System.out.println("Price after adding premium upgrade: $" + upgradedBooking.getBasePrice());

                System.out.println("\nThe Decorator pattern dynamically adds new behavior or responsibilities to an object without altering its structure.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 7 - Bridge Design Pattern
                System.out.println("\n*******************DESIGN PATTERN - Bridge Design Pattern *******************\n");

                // Apply seat selection feature
                booking.setFeature(new SeatChangeFeature("24D"));
                booking.applyFeature();

                // Apply meal preference feature
                booking.setFeature(new MealPreferenceFeature("Vegetarian"));
                booking.applyFeature();

                // Apply luggage preference feature
                booking.setFeature(new LuggageFeature(1));  // should not be more than 1
                booking.applyFeature();

                // Display final ticket details
                System.out.println("Trip Details: ");
                System.out.println("Passenger: " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName());
                System.out.println("Flight: " + booking.getFlight().getFlightID());
                System.out.println("Seat: " + booking.getSeatNumber());
                System.out.println("Meal: " + booking.getMealPreference());

                System.out.println("\nThe Bridge pattern separates an abstraction from its implementation, allowing them to vary independently..");
                System.out.println("\n************************************************************** ");


                // Design Pattern 8 - Prototype Design Pattern
                System.out.println("\n************* DESIGN PATTERN - Prototype Design Pattern **************\n");

                Booking duplicateBooking = (Booking) booking.cloneTicket();
                duplicateBooking.setCustomer(Emirates.getCustomers().get(1));
                duplicateBooking.setSeatNumber("25C");



                // Print out both tickets
                System.out.println("Actual Ticket: " + booking);
                System.out.println("Duplicate Ticket: " + duplicateBooking);
                System.out.println("\nThe Prototype pattern creates new objects by copying existing ones, ensuring efficient object creation.");
                System.out.println("\n************************************************************** ");


                // Design Pattern 9 - Command Design Pattern
                System.out.println("\n******************* DESIGN PATTERN - Command Design Pattern *******************\n");

                // Create commands
                Command bookCommand = new BookTicketCommand(duplicateBooking);
                Command cancelCommand = new CancelTicketCommand(duplicateBooking);

                // Create the invoker
                TicketInvoker invoker = new TicketInvoker();

                // Book a ticket
                invoker.setCommand(bookCommand);
                invoker.executeCommand();

                // Cancel the ticket
                invoker.setCommand(cancelCommand);
                invoker.executeCommand();

                System.out.println("\nThe Command pattern encapsulates requests as objects, allowing for parameterization, queuing, and reversible operations.");
                System.out.println("\n************************************************************** ");

                // Design Pattern 10 - Observer Design Pattern
                System.out.println("\n******************* DESIGN PATTERN - Observer Design Pattern *******************\n");

                Observer emailObserver = new EmailObserver();
                Observer smsObserver = new SMSObserver();

                // Attach observers to the ticket
                booking.addObserver(emailObserver);
                booking.addObserver(smsObserver);

                // Change ticket status and notify observers
                booking.setStatus("Booked");
                booking.setStatus("Checked-In");
                booking.setStatus("Canceled");

                System.out.println("\nThe Observer pattern establishes a one-to-many dependency, notifying all dependent objects (observers) of changes in a subject.");
                System.out.println("\n************************************************************** ");


                // Design Pattern 11 - Adapter Design Pattern
                System.out.println("\n*************** DESIGN PATTERN -  Adapter Design Pattern ***************\n");
//
                USCurrency us_currency = new USCurrency();
                FlightPriceCurrency inrCurrency = new INRCurrency();
                FlightPriceCurrency cadCurrency = new CanadaCurrency();
                FlightPriceCurrency yenCurrency = new JapanCurrency();

                FlightPriceCurrency c_adapter = new CurrencyAdapter(us_currency);

                System.out.println("US Currency...LegacyAPI");
                us_currency.showPriceCurrency(Emirates.getFlights().get(0).getPrice());

                System.out.println("Flight Price in INR Currency > Client API");
                inrCurrency.showcurrency(Emirates.getFlights().get(0).getPrice());

                System.out.println("Flight Price in Canadian Dollar Currency > Client API");
                cadCurrency.showcurrency(Emirates.getFlights().get(0).getPrice());

                System.out.println("Flight Price in Japanese Yen Currency > Client API");
                yenCurrency.showcurrency(Emirates.getFlights().get(0).getPrice());

                System.out.println("CurrencyAdapter\t\t>\t\tAdapter over Legacy API");
                c_adapter.showcurrency(Emirates.getFlights().get(0).getPrice());

               
                System.out.println("\nThe Adapter pattern allows incompatible interfaces to work together by converting one interface into another expected by the client.");
                System.out.println("\n************************************************************** ");
                 // Design Pattern 12 - State Design Pattern
                System.out.println("\n************ DESIGN PATTERN - State Design Pattern ************\n");

                FlightState fs = new FlightState(Emirates.getFlights().get(0).getFlightID());
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

                FlightState fs2 = new FlightState(Emirates.getFlights().get(1).getFlightID());
                fs2.delay();
                fs2.onBoarding();
                fs2.cancelled();
                fs2.inTransit();
                System.out.println("Flight Schedule status: " + fs2.isScheduled());

                System.out.println("\nThe State pattern allows an object to alter its behavior when its internal state changes, making it appear as if the object has changed its class.");
                System.out.println("\n************************************************************** ");


        }
}
