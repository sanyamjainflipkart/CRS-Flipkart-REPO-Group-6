package com.flipkart.service;

public interface ProfessorInterface {


    public  boolean addGrade(String studentId, String courseCode, String grade);


    /**
     * Method to view registered students by professor
     * @param professorID
     * @param course
     * @return  list of registered students
     */
    public  void viewRegisteredStudents(String professorID, String course);


    /**
     * Method to view Registered courses
     * @return  list of registered courses
     */
    public  void viewRegisteredCourses();

    /**
     * Method to register course
     * @param professorID
     * @param courseID
     * @return  boolean
     */
    public boolean registerCourse(String professorID, String courseID);

}
