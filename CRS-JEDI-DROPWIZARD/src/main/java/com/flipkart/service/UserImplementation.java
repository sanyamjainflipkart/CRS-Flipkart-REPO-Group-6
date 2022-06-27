package com.flipkart.service;

import com.flipkart.dao.UserDaoImplementation;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.exception.*;

public class UserImplementation implements UserInterface {
    UserDaoInterface udo  = UserDaoImplementation.getInstance();
    /**
     * Method to update password
     *
     * @param userID
     * @param newPassword
     * @return void
     */
    public boolean updatePassword(String userID, String newPassword) throws UserNotFoundException{
        if(udo.updatePassword(userID,newPassword))
        {
            return true;
        }
        else{
            throw new UserNotFoundException();
        }
    }


    /**
     * Method to login user
     * @param userID
     * @param password
     * @param role
     * @return  boolean
     */
    public boolean loginUser(String userID,String password, String role) throws UserNotFoundException {
        return udo.loginUser(userID,password); //check credentials
    }
    /**
     * Method to update user details
     * @param UserId
     * @param UserName
     * @return  void
     */
    public void updateUserDetails(String UserId, String UserName){

    }
}
