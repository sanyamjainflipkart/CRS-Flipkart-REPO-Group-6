/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.AdminImplementation;
import com.flipkart.service.ProfessorImplementation;
import com.flipkart.exception.NoCourseFoundException;

/**
 * @author saurabh.singh5
 *
 */
public class ProfessorApplication {

	/**
	 * @param args
	 */
	public void professorLoggedIn(String Id) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(ProfessorApplication.class);
		ProfessorImplementation professorImplementation=new ProfessorImplementation();
		while(true) {
			System.out.println("1. Select Courses");//Selecting courses for Professor
			System.out.println("2. View Registered Courses");
			System.out.println("3. Add Grades");
			System.out.println("4. Show Courses");
			System.out.println("5. View Registered Students");
			
			System.out.println("Enter your option");
			Scanner sc = new Scanner(System.in);
			
			int option = sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("Enter course id");
				String courseid=sc.next();
				
				System.out.println("Enter course name");
				String coursename=sc.next();
				
				professorImplementation.addCourse(Id ,courseid,coursename);
				//Status of allotment to be added whether alloted or not.
				break;
			case 2:
				try {
				professorImplementation.viewRegisteredCourses(Id);
				} 
				catch(NoCourseFoundException ex) {
					logger.info("Exception: "+ ex.getMessagewithid());
				}
				break;
			case 3:
				System.out.println("Enter  course Id");
				String courseId=sc.next();
				
				System.out.println("Enter student id");
				String studentId=sc.next();
				
				System.out.println("Enter  grade");
				int grade=sc.nextInt();
			
				
				AdminImplementation.addGrade(Id,courseId,studentId,grade);
				//Show successful grade allotment
				break;
			 case 4:
				 try {
				 professorImplementation.viewCourse();
				 }
				 catch(NoCourseFoundException ex) {
					 logger.error("Exception: "+ex.getMessage());
				 }
				 //shows available courses that can be picked
				break;
			 case 5:
				 System.out.println("Enter  course Id");
				 courseId=sc.next();
				 professorImplementation.viewRegisteredStudents(Id,courseId);
				 //shows available courses that can be picked
				break;
			default:
				System.out.println("Enter valid option");
		}
			
			System.out.println("Do you want to logout? Y N");
			char c = sc.next().charAt(0);
			if(c == 'Y') break;
			
		}
	}

}
