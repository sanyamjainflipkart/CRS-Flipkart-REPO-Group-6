package com.flipkart.bean;

public class User {
    private String userID;
    private String userName;
    private String password;
    private int role;

    /**
     * Parameterized constructor
     * @param userID
     * @param password
     * @param role
     */
    public User(String userID, String password, int role) {
        this.userID= userID;
        this.password = password;
        this.role = role;
    }

    /**
     * Default Constructor
     */
    public User() {}

    /**
     * Parameterized Constructor
     * @param userID
     */
    public User(String userID) {
        this.userID = userID;
    }

    /**
     * Method to get role of user
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * Method to set role of user
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Method to get UserId
     * @return the id
     */
    public String getId() {
        return userID;
    }

    /**
     * Method to set UserId
     * @param userID the id to set
     */
    public void setId(String userID) {
        this.userID = userID;
    }

    /**
     * Method to get UserName
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method to set UserName
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Method to get Password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set Password
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
