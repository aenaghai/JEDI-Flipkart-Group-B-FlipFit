package com.flipkart.client;

import com.flipkart.business.AdminService;
import com.flipkart.business.GymOwnerService;

import java.util.*;

public class GymOwnerClient {

    GymOwnerService gymOwnerService = new GymOwnerService();
    AdminService  adminService = new AdminService();

    public boolean login (String userName, String password) {
        //verify cred
        gymOwnerMainPage();
        return false;
    }


    public void gymOwnerMainPage() {
        Scanner scanner = new Scanner(System.in);
        GymOwnerService gymOwnerService = new GymOwnerService();

        while (true) {
            System.out.println("Gym Owner Service Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Add Gym Center");
            System.out.println("4. Remove Gym Center");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    boolean loginStatus = gymOwnerService.login(userName, password);
                    System.out.println("Login status: " + (loginStatus ? "Success" : "Failed"));
                    break;
                case 2:
                    String userId = UUID.randomUUID().toString();
                    System.out.print("Enter username: ");
                    String registerUserName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    System.out.print("Enter Aadhar card number: ");
                    String adharCardNumber = scanner.nextLine();
                    List<String> gymCenterId = new ArrayList<>();
                    System.out.print("Enter number of gym centers: ");
                    int numCenters = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numCenters; i++) {
                        System.out.print("Enter gym center ID " + (i + 1) + ": ");
                        gymCenterId.add(scanner.nextLine());
                    }
                    boolean registerStatus = gymOwnerService.register(userId, registerUserName, email, registerPassword, adharCardNumber, gymCenterId);
                    System.out.println("Registration status: " + (registerStatus ? "Success" : "Failed"));
                    break;
                case 3:
                    String ownerId = UUID.randomUUID().toString();
                    System.out.print("Enter gym ID: ");
                    String gymId = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter cost: ");
                    int cost = scanner.nextInt();
                    scanner.nextLine();
                    boolean addCenterStatus = gymOwnerService.addCenter(ownerId, gymId, city, capacity, cost);
                    System.out.println("Add center status: " + (addCenterStatus ? "Success" : "Failed"));
                    break;
                case 4:
                    System.out.print("Enter owner ID: ");
                    String removeOwnerId = scanner.nextLine();
                    System.out.print("Enter gym ID: ");
                    String removeGymId = scanner.nextLine();
                    boolean removeCenterStatus = gymOwnerService.removeCenter(removeOwnerId, removeGymId);
                    System.out.println("Remove center status: " + (removeCenterStatus ? "Success" : "Failed"));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

