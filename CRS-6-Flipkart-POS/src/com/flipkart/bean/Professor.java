package com.flipkart.bean;

public class Professor extends User{

    private String professorDepartment;
    private String professorDesignation;
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

}
