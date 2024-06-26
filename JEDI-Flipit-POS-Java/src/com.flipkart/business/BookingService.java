package com.flipkart.business;

public class BookingService {
    public boolean addBooking (String userId, String slotId, String gymId) {
        //check if booking is valid
        //add it to the booking table w bookingId and userId
        return false;
    }

    public boolean checkValidBooking (String slotId, String gymId) {
        //check if the slot is there in the gym
        return false;
    }

    public boolean cancelBooking (String bookingId) {
        //remove booking from booking table
        return false;
    }
}
