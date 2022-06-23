package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.service.AdminInterface;

public class AdminApplication {
    Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        AdminApplication a = new AdminApplication();
        a.showMenu();
    }

    public void showMenu(){

        System.out.println("----------------Admin Menu----------------\n");

        createMenu();

        System.out.println("\nEnter Your Choice");
        int userInput = sc.nextInt();

        while (userInput <= 6) {

            switch (userInput) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    deleteCourse();
                    break;
                case 3:
                    addProfessor();
                    break;
                case 4:
                    // Display all updated courses
                    displayCourses();
                    break;
                case 5:
                    // Allot Course
                    studentCourseAllot();
                    break;
                case 6:
                    // View Student Data
                    activateGradeCard();
                    break;

                default:
                    System.out.println("Invalid Input");
            }
            createMenu();
            System.out.println("\nEnter Your Choice");
            userInput = sc.nextInt();
        }
    }


    private void createMenu() {
        System.out.println("1  Add Course");
        System.out.println("2  Delete Course");
        System.out.println("3  Add Professor");
        System.out.println("4  View All Courses");
        System.out.println("5  Student Course Allocation");
        System.out.println("6  Activate Grade Card");
        //System.out.println("7  Display all courses");
    }

    private void displayCourses(){
        AdminInterface.displayCourses();
    }

    private void addCourse(){
        System.out.println("Enter Course Code");
        String courseId = sc.next();

        //Course course = new Course(10, courseName, courseId);
        System.out.println("Enter Course name: ");
        String course_name = sc.next();
        AdminInterface.addCourse(course_name);
        System.out.println("Course added successfully");
    }

    public void deleteCourse(){
        System.out.print("Enter Course name : ");
        String course_name = sc.next();
        AdminInterface.deleteCourse(course_name);
        System.out.println("Course deleted successfully");
    }

    private void addProfessor(){
        System.out.println("Enter details of the Professor to be added: ");

        System.out.println("Enter ProfessorId: ");
        String id = sc.next();

        System.out.println("Enter Department: ");
        String department = sc.next();

        System.out.println("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();
        System.out.println();

        Professor professor = new Professor();

        professor.setDepartment(department);
        professor.setId(id);

        AdminInterface.addProfessor(name);

        System.out.println("Professor added successfully");
    }

    private void approveRegistration() {
        System.out.print("Enter Student's ID: ");
        String studentUserId = sc.next();

        AdminInterface.approveStudent(studentUserId);
        System.out.println("Student Registration is being Approved\n");
    }
    private void viewCourses() {
//        List<Course> courseList = AdminInterface.viewCourse();
//        if(courseList!=null && courseList.size()>0) {
//            System.out.println("Course Details\n");
//            for (Course c : courseList) {
//                System.out.println(
//                        " Id -> " + c.getCourseId() + " Name -> " + c.getCourseName() + "  Seat Left -> " + c.getCount());
//            }
//        }
    }

    private void activateGradeCard() {
        System.out.print("Enter Student's ID :");
        String studentId = sc.next();

        Student stud = new Student();
        stud = AdminInterface.viewStudentData(studentId);

        System.out.println("Details are  ->");
        System.out.println("Id -> " + stud.getId() + " Name -> " + stud.getUserName() + " Branch -> " + stud.getBranch());

//        if(!stud.isReportApproved()) {
//            List<RegisteredCourses> registeredCourses = AdminInterface.activateGradeCard(studentId);
//            int count = 0;
//
//            for(RegisteredCourses course:registeredCourses) {
//                System.out.println("CourseId -> " + course.getCourseId() + " Grade " + course.getGrade());
//                count++;
//            }
//
//            AdminInterface.approveStudentRegistration(studentId);
//            System.out.println("Student Report is Generated");
//        }
    }

    private void studentCourseAllot() {
        System.out.print("Enter Student's ID: ");
        String studentId = sc.next();
        System.out.print("Enter Course ID: ");
        String courseId = sc.next();
//        Set<String> courseList = AdminInterface.viewSelectedCourse(studentId);
//
//        AdminInterface.allotCourse(studentId,courseID);
        System.out.println("\nStudent Has Been Registered");
    }
}