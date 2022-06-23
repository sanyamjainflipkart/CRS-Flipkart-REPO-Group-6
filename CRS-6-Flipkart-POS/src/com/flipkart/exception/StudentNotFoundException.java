package com.flipkart.exception;
public class StudentNotFoundException extends Exception{

    String sid;
    String courseId;

    public StudentNotFoundException(String id,int s) {
        this.courseId = id;
    }
    /**
     * Parameterized constructor
     * @param sid : student id
     */
    public StudentNotFoundException(String sid){
        this.sid = sid;
    }

    /**
     * Message thrown by exception
     */
    public String getMessage(){
        return "Student with id : "+sid+" cannot be found";
    }

    public String getMessageWithCourse() {
        return "No students are registered for course with id : "+ this.courseId;
    }
}