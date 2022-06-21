package com.flipkart.bean;

public class Student extends User {
    private String studentDepartment;
    private boolean isApproved;
    private int semesterNumber;


    /**
     * Parameterized constructor
     * @param id
     * @param password
     */
    public Student(String id, String password) {
        super(id,password,1);
    }

    /**
     * parameterized constructor
     * @param id
     */
    public Student(String id) {
        super(id);
    }

    /**
     * Default constructor
     */
    public Student() {
        super();
    }


    /**
     * Method to get branch
     * @return String
     */
    public String getStudentDepartment() {
        return studentDepartment;
    }
    /**
     * Method to set branch
     * @return String
     */
    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }
    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    /**
     * Method to get isApproved status
     * @return boolean
     */
    public boolean isApproved() {
        return isApproved;
    }


    /**
     * Method to set isApproved status
     * @param isApproved
     */
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getBranch() {
        String s;
        s = "";
        return s;
    }

    public boolean isReportApproved() {
        return true;
    }
}
