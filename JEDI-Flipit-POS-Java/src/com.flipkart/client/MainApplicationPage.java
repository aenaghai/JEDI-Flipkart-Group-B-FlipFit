package com.flipkart.client;

import java.util.Scanner;


public class MainApplicationPage {
    public static void main(String[] args) {
        homePage();
    }

    private static void homePage() {
        System.out.println("Choose a option : \n1: Enter 1 to login\n2:Enter 2 to register\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1) {
           login();
        }
        else if(choice == 2) {
            register();
        }
        else {
            System.out.println("Please choose a valid option");
        }
    }

    private static AdminClient adminClient = new AdminClient();
    private static CustomerClient customerClient = new CustomerClient();
    private static GymOwnerClient gymOwnerClient = new GymOwnerClient();

    private static void login() {
        System.out.println("Please Choose : \n1: Enter 1 to login as Admin\n2: Enter 2 to login as Customer\n3: " +
                "Enter 3 to login as GymOwner");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Passkey");
            String password = scanner.next();
            adminClient.login(userName, password);
        }
        else if (choice == 2) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            customerClient.login(userName, password);
        }
        else if (choice == 3) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            gymOwnerClient.login(userName, password);
        }
        else {
            System.out.println("Please choose a valid option");
        }
    }

    private static void register() {
        System.out.println("Please Choose : \n1: Enter 1 to register as Customer\n2: Enter 2 to register as GymOwner\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            customerClient.register();
        }
        else if (choice == 2) {
            gymOwnerClient.register();
        }
        else {
            System.out.println("Please choose a valid option");
        }
    }
}
