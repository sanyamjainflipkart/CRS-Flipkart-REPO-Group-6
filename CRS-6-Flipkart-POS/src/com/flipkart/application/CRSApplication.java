package com.flipkart.application;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {

        menu();
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

        while (userInput == 1 || userInput == 2 || userInput == 3) {
            switch (userInput) {
                case 1:
                    // login
                    CRSApplication.loginUser();
                    break;
                case 2:
                    // student registration
                    CRSApplication.registerStudent();
                    break;
                case 3:
                    // update Password
                    CRSApplication.updatePassword();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
                menu();
                userInput = sc.nextInt();
        }

    }

    public static void menu() {
        System.out.println("----------Welcome to Course Management System---------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. UpdatePassword");
        System.out.println("4. Exit");
        System.out.println("Enter user input");
    }

    public static void registerStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id:");
        String id = sc.next();

        System.out.println("Enter Name:");
        String name = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        System.out.println("Enter Branch:");
        String branch = sc.next();

        //int role = 1;

        //StudentServiceInterface studentInterface = new StudentService();

        //String newUserID = studentInterface.signup(id, password, branch, name, role);

        System.out.println("Thankyou For Registration, Wait for the Admin Approval");

    }

    public static void loginUser() {
        String id, password;

        System.out.println("-----------------Login Menu------------------");

        System.out.println("Enter id ");
        Scanner sc = new Scanner(System.in);
        id = sc.next();

        System.out.println("Enter password");
        password = sc.next();

        //int loggedIn = -1;

        //loggedIn = userInterface.verifyUser(id, password);

//        if (loggedIn ==1 || loggedIn == 2 || loggedIn == 3) {
//            LocalDateTime localDateTime = LocalDateTime.now();
//
//            switch (loggedIn) {
//                // Student
//                case 1: {
//                    boolean isApproved = userInterface.verifyApproval(id);
//                    if(isApproved) {
//                        System.out.println("Student Has Logged In at : " + localDateTime + " ->  Login Successful");
//                        StudentApplication studentApp = new StudentApplication();
//                        studentApp.studentLoggedin(id);
//                    }else {
//                        System.out.println("Failed to login, you have not been approved by the administration!");
//                    }
//                    break;
//                }
//
//
//                case 2:
//                    System.out.println("Professor Has Logged In at : " + localDateTime + " ->  Login Successful");
//                    ProfessorApplication professorApplication = new ProfessorApplication();
//                    professorApplication.professorLoggedIn(id);
//                    break;
//
//                case 3:
//                    System.out.println("Admin Has Logged In at : " + localDateTime + " ->  Login Successful");
//                    AdminApplication adminCRS = new AdminApplication();
//                    adminCRS.showMenu();
//                    break;
//            }
//        }else {
//            System.out.println("Invalid Credentials!");
//        }
        System.out.println("User logged in successfully");
    }

    public static void updatePassword() {
        String id, password;
        System.out.println("Enter id ");
        Scanner sc = new Scanner(System.in);
        id = sc.next();

        System.out.println("Enter New Password");
        password = sc.next();

        boolean isUpdated = false;

        //isUpdated = userInterface.updatePassword(id,password);

        //if(isUpdated)
            System.out.println("Password Updated Successfully");
//        else
//            System.out.println("Not Updated");
    }
}
