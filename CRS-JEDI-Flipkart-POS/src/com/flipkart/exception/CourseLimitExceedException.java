package com.flipkart.exception;

public class CourseLimitExceedException extends Exception{

    private int num;

    public CourseLimitExceedException(int num )
    {
        this.num = num;
    }

    public int getCourseLimit()
    {
        return num;
    }

    @Override
    public String getMessage()
    {
        return "You have already registered for " + num + " courses";
    }


}

