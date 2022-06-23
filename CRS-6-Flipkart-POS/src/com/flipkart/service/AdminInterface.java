package com.flipkart.service;
import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminInterface {
    ArrayList<String> courses = new ArrayList<String>(100);
    static void addCourse(String course) {
        courses.add(course);
    }

    static void deleteCourse(String course) {
        courses.remove(course);
    }

    static void displayCourses(){
        for (int i = 0; i < courses.size();i++)
        {
            System.out.println(courses.get(i));
        }
    }

    static void addProfessor(Professor professor) {
    
    }

    static void approveStudent(String studentUserId) {
        
    }

    static List<String> viewCourse() {
        List tl = new ArrayList<String>();
        return tl;
    }

    static Student viewStudentData(String studentId) {
        Student s = new Student();
        return s;
    }

    static List<String> activateGradeCard(String studentId) {
        List s = new ArrayList<String> ();
        return s;
    }

    public void generateReportCard();
    public void removeCourse();
    public void approveStudentRegistration();
    public void addProfessor();

}
