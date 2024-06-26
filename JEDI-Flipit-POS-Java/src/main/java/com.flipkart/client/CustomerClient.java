/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class CustomerClient {
    CustomerService customerService = new CustomerService();
    public boolean login (String username, String password) {
        //validate cred from the DB
        customerMainPage();
        return false;
    }
    public void register () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Enter your card number: ");
        String cardNumber = scanner.nextLine();

        customerService.registerCustomer(userName, password, email, city, cardNumber);

    }

    public void customerMainPage () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to FlipFit Gym Booking System");
            System.out.println("1. View all gym centers in a city");
            System.out.println("2. View all free slots in a gym on a specific date");
            System.out.println("3. View all bookings in a gym on a specific date");
            System.out.println("4. Book a slot");
            System.out.println("5. Cancel a slot");
            System.out.println("6. Register as a new customer");
            System.out.println("7. Login as a customer");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    List<FlipFitGym> gyms = customerService.viewAllGymCenters(city);
                    System.out.println(gyms);  // Assuming FlipFitGym has a toString() method
                    break;
                case 2:
                    System.out.print("Enter gym ID: ");
                    String gymId = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    List<Slot> freeSlots = customerService.viewAllFreeSlots(gymId, date);
                    System.out.println(freeSlots);  // Assuming Slot has a toString() method
                    break;
                case 3:
                    System.out.print("Enter gym ID: ");
                    String gymIdForBookings = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate bookingDate = LocalDate.parse(scanner.nextLine());
                    List<Booking> bookings = customerService.viewAllBookings(gymIdForBookings, bookingDate);
                    System.out.println(bookings);  // Assuming Booking has a toString() method
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter gym ID: ");
                    String gymIdForBooking = scanner.nextLine();
                    System.out.print("Enter slot ID: ");
                    String slotId = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate bookingDateForSlot = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:MM): ");
                    LocalTime bookingTime = LocalTime.parse(scanner.nextLine());
                    boolean bookingStatus = customerService.bookSlot(userId, gymIdForBooking, slotId, bookingDateForSlot, bookingTime);
                    System.out.println("Booking status: " + (bookingStatus ? "Success" : "Failed"));
                    break;
                case 5:
                    System.out.print("Enter gym ID: ");
                    String gymIdForCancellation = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate cancellationDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:MM): ");
                    LocalTime cancellationTime = LocalTime.parse(scanner.nextLine());
                    boolean cancellationStatus = customerService.cancelSlot(gymIdForCancellation, cancellationDate, cancellationTime);
                    System.out.println("Cancellation status: " + (cancellationStatus ? "Success" : "Failed"));
                    break;
                case 6:
                    System.out.print("Enter username: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String registrationCity = scanner.nextLine();
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    boolean registrationStatus = customerService.registerCustomer(userName, password, email, registrationCity, cardNumber);
                    System.out.println("Registration status: " + (registrationStatus ? "Success" : "Failed"));
                    break;
                case 7:
                    System.out.print("Enter username: ");
                    String loginUserName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    boolean loginStatus = customerService.checkValidCustomer(loginUserName, loginPassword);
                    System.out.println("Login status: " + (loginStatus ? "Success" : "Failed"));
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
