package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
    public boolean updatePassword(String userId, String newPassword);
    public boolean loginUser(String userID, String password);
}
