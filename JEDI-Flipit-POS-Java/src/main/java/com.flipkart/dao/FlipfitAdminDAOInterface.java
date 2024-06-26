package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface FlipfitAdminDAOInterface {
    public boolean approveGymOwner (String gymOwnerId, boolean status);
    public List<GymOwner> viewNonApprovedSlots();
    public boolean changePassword(String userName, String oldPassword, String newPassword);
    public void login(String userName, String password);
}
