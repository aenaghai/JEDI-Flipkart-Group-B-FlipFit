package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.List;

public class AdminDAOImpl implements AdminDAOInterface{
    @Override
    public boolean approveGymOwner(String gymOwnerId, boolean status) {
        return false;
    }

    @Override
    public List<GymOwner> viewNonApprovedSlots() {
        return null;
    }

    @Override
    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void login(String userName, String password) {

    }
}
