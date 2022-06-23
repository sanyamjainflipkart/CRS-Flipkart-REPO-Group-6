package com.flipkart.exception;

public class CourseAlreadyAssignedException extends Exception{
    private String courseId;

    public CourseAlreadyAssignedException(String courseId) {
        this.courseId = courseId;
    }

    public String getMessage() {
        return "Course with id : "+ courseId+ " does not exist or already been taken";
    }
}
