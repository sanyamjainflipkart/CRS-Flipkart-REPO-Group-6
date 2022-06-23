package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseAlreadyAssignedException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.utils.DBConnection;

public class ProfessorDaoOperation implements ProfessorDaoInterface{
    Connection conn = DBConnection.getConnection();
    PreparedStatement stmt = null;
    private static Logger logger = Logger.getLogger(ProfessorDaoOperation.class);

    public boolean selectCourse(String profId,String courseId, String courseName) {
        // TODO Auto-generated method stub
        try {

            String query = SQLQueriesConstant.ASSIGN_COURSE_TO_PROF;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, profId);
            stmt.setString(2, courseId);
            stmt.setString(3, courseName);
            //	stmt.setString(4, "aaaa");

            int result = stmt.executeUpdate();

            if(result==0)
            {
                throw new CourseAlreadyAssignedException(courseId);
            }
            else
            {
                logger.info("Course has been added Successfully");
                return true;
            }

        }catch (CourseAlreadyAssignedException u) {
            // TODO Auto-generated catch block
            logger.error("Exception : " + u.getMessage());
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }
        return false;
    }

    public List<Course> viewRegisteredCourses(String Id) {
        // TODO Auto-generated method stub

        List<Course> RegisteredCourses = new ArrayList<Course>();

        try {

            String sql=SQLQueriesConstant.VIEW_PROF_COURSES;

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rc = stmt.executeQuery();

            while(rc.next()) {

                String cid  = rc.getString("CourseId");
                String cname = rc.getString("CourseName");

                Course c= new Course();
                c.setCourseId(cid);
                c.setCourseName(cname);

                RegisteredCourses.add(c);

            }

            stmt.close();
            //  conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());

        }
        return RegisteredCourses;
    }

    public boolean addGrades(String professorId, String courseId, String studentId, int grade) {
        String query;
        if(checkGradeValidity(professorId,studentId,courseId)) {

            if(CheckGradeUpdateType(studentId , courseId)) {

                System.out.println("Record already exists\n");
                System.out.print("Press N if you do not want to overwrite :  ");
                Scanner sc = new Scanner(System.in);
                String choice = sc.next();
                System.out.println();

                if(choice.equalsIgnoreCase("N")) {
                    logger.info("Mark updation cancelled");
                    return true;
                }

            }
            try {
                query = SQLQueriesConstant.ADD_GRADES;
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, grade);
                stmt.setString(2, studentId);
                stmt.setString(3, courseId);

                int result = stmt.executeUpdate();
                stmt.close();
                if(result!=0)
                    logger.info("Sucessfully updated marks!!");
                else
                {
                    logger.info("Mark updation failed!");
                    throw new GradeNotAddedException(courseId,studentId);
                }

            }catch(GradeNotAddedException g){
                logger.error("Exception" + g.getMessage());
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                logger.error("Exception" + e.getMessage());
                return false;
            }
            return true;
        }
        logger.error("Student does not exist / does not take the course \n");
        return false;
    }

    public List<Course> showCourses() {

        List<Course> courseList =new ArrayList<Course>();


        try {

            String sql=SQLQueriesConstant.COURSE_SELECTION_LIST;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet courses =  stmt.executeQuery(sql);

            while(courses.next()){


                String courseId  = courses.getString("CourseId");
                String courseName = courses.getString("CourseName");
                int seatCount = courses.getInt("SeatCount");


                Course course =new Course();
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                course.setCount(seatCount);

                courseList.add(course);
            }

            stmt.close();
            // conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }


        return courseList;

    }

    public void viewRegisteredStudents(String id, String courseId) throws StudentNotFoundException{
        try {
            if(isProfCourse( id,  courseId))
            {
                String query = SQLQueriesConstant.VIEW_REGISTERED_STUDENTS;
                stmt = conn.prepareStatement(query);
                stmt.setString(1, courseId);
                ResultSet registeredStudents =  stmt.executeQuery();


                while(registeredStudents.next()) {

                    System.out.println("\tStudent Id:"+ registeredStudents.getString("id")+ "\tStudent Name :" + registeredStudents.getString("name"));


                }


            }
            else{
                logger.error("Professor Not Registered for given Course");
                return ;
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }

    }

    private boolean checkGradeValidity(String professorId,String studentId, String courseId) {
        // TODO Auto-generated method stub
        try {
            String query = SQLQueriesConstant.CHECK_STUDENT_REGISTRATION_FOR_COURSE;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, studentId);
            stmt.setString(2, courseId);
            ResultSet registeredCourses =  stmt.executeQuery();
            //	List<Course> courseList
            if(registeredCourses.next()) {

                if(isProfCourse( professorId, courseId) ) {
                    stmt.close();
                    return true;

                }

            }
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }

        return false;
    }

    private boolean CheckGradeUpdateType(String studentId, String courseId) {
        // TODO Auto-generated method stub
        String query = SQLQueriesConstant.CHECK_GRADE_UPDATE_TYPE;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, studentId);
            stmt.setString(2, courseId);

            ResultSet grade = stmt.executeQuery();

            if(grade.next())
                return true;
            else{
                return false;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }

        return false;
    }
    private boolean isProfCourse(String professorId, String courseId)
    {
        try {


            String sql = SQLQueriesConstant.CHECK_PROF_COURSE;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, professorId);
            stmt.setString(2, courseId);
            ResultSet course =  stmt.executeQuery();

            if(course.next()) {
                stmt.close();
                return true;

            }

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error("Exception" + e.getMessage());
        }
        return false;
    }
}
