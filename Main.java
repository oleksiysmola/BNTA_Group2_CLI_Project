package com.bntaairport;

import com.bntaairport.airport.Airport;
import com.bntaairport.customer.Customer;
import com.bntaairport.email.EmailValidation;
import com.bntaairport.flight.Flight;
import com.bntaairport.flight.FlightDestination;
import com.bntaairport.flight.FlightService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight(1, LocalDateTime.of(2022,03,10,1,15), FlightDestination.SPAIN, 5, new Customer[5]);
        Flight flight2 = new Flight(2, LocalDateTime.of(2022,04,12,2,15), FlightDestination.AUSTRALIA, 6, new Customer[6]);
        Flight flight3 = new Flight(3, LocalDateTime.of(2022,05,13,3,15), FlightDestination.FRANCE, 3, new Customer[3]);
        Flight flight4 = new Flight(4, LocalDateTime.of(2022,06,14,4,15), FlightDestination.IRELAND, 7, new Customer[7]);
        Flight flight5 = new Flight(5, LocalDateTime.of(2022,07,15,6,15), FlightDestination.NORWAY, 4, new Customer[4]);

        Airport airport = new Airport("BNTA London", 5);
        airport.addFlight(flight1);
        airport.addFlight(flight2);
        airport.addFlight(flight3);
        airport.addFlight(flight4);
        airport.addFlight(flight5);

        System.out.println(airport.toString());


        System.out.println("Welcome to BNTA Airlines");
        System.out.println("------------------------");
        boolean customerOrStaffValid = false;
        while (customerOrStaffValid==false){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 if you are a customer, enter 2 if you are staff");
            String customerOrStaff = scanner.nextLine();
            switch (customerOrStaff) {
                case "1":
                    System.out.println("Enter full name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    //------Email Validator-------
                    EmailValidation emailValidation = new EmailValidation();
                    boolean emailChecker = false;
                    while (emailChecker == false) {
                        if (emailValidation.validateEmail(email) == true) {
                            emailChecker = true;
                        } else {
                            System.out.println("Please enter a valid email");
                            email = scanner.nextLine();
                        }
                    }
                    //-----------------------------

                    System.out.println("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter passport number: ");
                    String passportNumber = scanner.nextLine();

                    Customer customer = new Customer(222, name, email, phoneNumber, passportNumber);

                    customerOrStaffValid = true;

                    boolean viewBookOrCancelValid = false;
                    while (viewBookOrCancelValid==false){
                        FlightService flightService = new FlightService();
                        System.out.println("Enter 1 to view current flights, Enter 2 to book a new flight, Enter 3 to view your bookings, Enter 4 to a cancel a flight: ");

                        String viewBookOrCancel = scanner.nextLine();
                        switch (viewBookOrCancel){
                            case "1":
                                flightService.displayFlights(airport);
                                System.out.println("");

                                break;
                            case "2":

                                System.out.println("Please enter the flight number of the flight you would like to book: ");
                                String flightNum = scanner.nextLine();

                                flightService.bookFlight(flightService.findFlightByNum(flightNum, airport), customer);
                                //when the user selects 2 (book a flight) they cannot see what they can book i.e. they
                                //need to see the list of options


                                break;

                                case "3":
                                    System.out.println("Details of your current flight booking are...");
                                    flightService.viewBookings(airport, customer);

                            //Darshil added this and the viewBookings() method in Flight Service class to show the
                                    // customer their existing bookings
                            //Currently, after user looks at their existing bookings, they are asked if they want to
                                    // cancel their flights, should really re-display the main menu to ask them if they
                                    // want to book new, cancel flight etc?



                            case "4":

                                System.out.println("Please enter the flight number of the flight you would like to cancel: ");
                                flightNum = scanner.nextLine();

                                flightService.cancelFlight(flightService.findFlightByNum(flightNum, airport), customer);

                                viewBookOrCancelValid=true;
                                break;
                            default:
                                System.out.println("Must only enter 1, 2 or 3!");
                        }
                        System.out.println();
                    }

                    break;
                case "2":
                    System.out.println("blah");
                    customerOrStaffValid=true;
                    break;
                default:
                    System.out.println("Must only enter 1 or 2!");
            }
        }
    }
}