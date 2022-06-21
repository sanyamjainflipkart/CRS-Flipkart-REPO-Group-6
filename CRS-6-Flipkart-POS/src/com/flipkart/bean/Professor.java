package com.flipkart.bean;

public class Professor extends User{
    private String professorDepartment;
    private String professorDesignation;

    /**
     * Default constructor
     */
    public Professor() {
        super();
    }

    public String getProfessorDepartment() {
        return professorDepartment;
    }

    public void setProfessorDepartment(String professorDepartment) {
        this.professorDepartment = professorDepartment;
    }
    public String getProfessorDesignation() {
        return professorDesignation;
    }

    public void setProfessorDesignation(String professorDesignation) {
        this.professorDesignation = professorDesignation;
    }

    public void setDepartment(String department) {
        this.professorDepartment = department;
    }
}

