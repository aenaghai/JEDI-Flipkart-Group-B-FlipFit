package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CustomerService implements CustomerInterface{

    public List<FlipFitGym> viewAllGymCenters(String city) {
        return null;
    }

    public List<Slot> viewAllFreeSlots (String gymId, LocalDate date) {

        return null;
    }

    public List<Booking> viewAllBookings (String gymId, LocalDate date) {
        //use the booking table
        return null;
    }

    public boolean bookSlot (String userId, String gymId, String slotId, LocalDate date, LocalTime time) {
        //will have to check if the slot is valid and not already taken
        return false;
    }

    public boolean cancelSlot (String gymId, LocalDate date, LocalTime time) {
        return false;
    }

    public boolean registerCustomer(String userName, String password, String email, String city, String cardNumber) {
        //verify details, check if the user is not already registered
        //store the customer

        return true;
    }

    public boolean checkValidCustomer (String userName, String password) {
        //check DB

        return false;
    }

    @Override
    public boolean changePassword(String userName, String password, String newPassword) {
        return true;
    }

    @Override
    public void login(String userName, String password) {
        return;
    }
}
