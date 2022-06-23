package com.flipkart.dao;

import java.util.List;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.bean.Course;
public interface ProfessorDaoInterface {

    public boolean selectCourse(String profId, String courseId,String courseName);
    public List<Course> viewRegisteredCourses(String id) ;
    public boolean addGrades(String professorId ,String courseId,String studentId,int grade) ;
    public List<Course> showCourses() ;
    public void viewRegisteredStudents(String id, String courseId) throws StudentNotFoundException;

}
