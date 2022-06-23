package com.flipkart.exception;

public class GradeNotAddedException extends Exception{
    private String sid;
    private String courseId;

    /**
     * Constructor
     * @param studentId : student id
     * @param courseId: course id
     */
    public GradeNotAddedException(String studentId,String courseId)
    {
        this.sid=studentId;
    }

    /**
     * Getter function for studentId
     * @return sid
     */
    public String getStudentId()
    {
        return sid;
    }

    /**
     * Message to be thrown
     */
    public String getMessage() {
        return "Marks for student with id : "+sid+" and course with id: "+courseId+" cannot be added";
    }
}
