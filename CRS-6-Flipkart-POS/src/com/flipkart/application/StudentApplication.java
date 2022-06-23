package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.AdminImplementation;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.NotificationImplementation;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.StudentImplementation;
import com.flipkart.service.StudentInterface;


public class StudentApplication {
    NotificationInterface notificationService = new NotificationImplementation();
    AdminInterface adminInterface = new AdminImplementation();

    public static void main(String args[]){
        StudentApplication s = new StudentApplication();
        s.studentLoggedin("1");
    }
    public void studentLoggedin(String id) {
        StudentInterface studentService = new StudentImplementation();

        CreateMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your option");
        int option = sc.nextInt();
        while(option != 11) {
            switch (option) {
                case 1:
                    studentService.registerForSemester(id);
                    break;
                case 2:
                    studentService.viewReportcard(id);
                    break;
                case 3:
                    studentService.viewRegisteredCourses(id);
                    break;
                case 4:
                    notificationService.showNotifications(id);
                    break;
                default:
                    System.out.println("Enter valid option");
            }
            CreateMenu();
            System.out.println("\nEnter Your Choice");
            option = sc.nextInt();
        }
    }

    private void CreateMenu() {
        System.out.println("1. Registration");
        System.out.println("2. View Report Card");
        System.out.println("3. View Registered Courses");
        System.out.println("4. Show Notifications");
        System.out.println("5. Pay Fees");

    }


}
