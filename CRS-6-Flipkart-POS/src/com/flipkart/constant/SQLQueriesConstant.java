package com.flipkart.constant;

public class SQLQueriesConstant {
    public static final String  ASSIGN_COURSE_TO_PROF ="update course set PID = ? where courseID = ? and courseName = ? and PID is null";
    public static final String  VIEW_PROF_COURSES = "select CourseId, CourseName from course where PId = ? ";
    public static final String  ADD_GRADES = "UPDATE registeredcourse SET grade = ? where sId = ? and courseId = ? LIMIT 1";
    public static final String  COURSE_SELECTION_LIST ="Select CourseId,courseName,seatCount from course where pid is null";
    public static final String  VIEW_REGISTERED_STUDENTS ="Select user.id ,user.name from (user INNER JOIN registeredcourse ON registeredcourse.sid = user.id ) where courseId = ? and IsRegistered = 1";

    public static final String  CHECK_STUDENT_REGISTRATION_FOR_COURSE = "select * from registeredcourse where sid = ? and courseId = ? and IsRegistered = 1";

    public static final String  CHECK_GRADE_UPDATE_TYPE = "select * from registeredcourse where sid = ? and courseId = ? and grade is not null";

    public static final String  CHECK_PROF_COURSE = "select * from course where pid = ? and courseId = ? ";
}
