package com.flipkart.exception;

public class CourseNotFoundException extends Exception{

    String courseId;

    /**
     * Parameterized constructor
     * @param courseId : course id
     */
    public CourseNotFoundException(String courseId){
        this.courseId = courseId;
    }

    /**
     *Message thrown by exception
     */
    public String getMessage(){
        return "Course with courseId : "+courseId+" is not found";
    }
}