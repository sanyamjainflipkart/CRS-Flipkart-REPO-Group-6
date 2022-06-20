package com.flipkart.bean;

public class Course {
    private int Count;
    private String CourseName;
    private String CourseId;
    private String Professor;
    private boolean IsOffered;
    private double Marks;
    public Course(int Count,String CourseName,String CourseId)
    {
        this.Count=Count;
        this.CourseName = CourseName;
        this.CourseId=CourseId;
    }

    public Course(int Count,String CourseName,String CourseId,String Professor)
    {
        this.Count=Count;
        this.CourseName = CourseName;
        this.CourseId=CourseId;
        this.Professor=Professor;
    }



    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String CourseId) {
       this.CourseId = CourseId;
    }

    public String getProfessor() {
        return Professor;
    }

    public void setProfessor(String professor) {
        this.Professor = professor;
    }

    public boolean IsOffered()
    {
        return IsOffered;
    }

    public void setOffered(boolean IsOffered) {
        this.IsOffered=IsOffered;
    }

    public double getMarks() {
        return Marks;
    }

    public void setMarks(double Marks) {
        this.Marks = Marks;
    }
}
