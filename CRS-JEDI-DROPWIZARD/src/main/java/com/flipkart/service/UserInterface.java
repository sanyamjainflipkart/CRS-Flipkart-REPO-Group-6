package com.flipkart.service;
// import com.flipkart.exception.UserNotFoundException;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {


    /**
     * Method to update password
     *
     * @param userId
     * @param newPassword
     * @return void
     */
    public boolean updatePassword(String userId, String newPassword)throws UserNotFoundException;

    /**
     * Method to login user
     * @param userId
     * @param password
     * @param role
     * @return  boolean
     */
    public boolean loginUser(String userId,String password, String role) throws UserNotFoundException;

    /**
     * Method to update user details
     * @param UserId
     * @param Name
     * @return  void
     */
    public void updateUserDetails(String UserId,String Name);


}
