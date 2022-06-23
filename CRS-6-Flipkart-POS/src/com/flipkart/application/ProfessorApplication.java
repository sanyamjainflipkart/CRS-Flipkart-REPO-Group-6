/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.service.AdminInterface;
import org.apache.log4j.Logger;

import com.flipkart.service.AdminImplementation;
import com.flipkart.service.ProfessorImplementation;
import com.flipkart.exception.NoCourseFoundException;


public class ProfessorApplication {
	public static void main(String args[]){
		ProfessorApplication p = new ProfessorApplication();
		p.professorLoggedIn("1");
	}
	public void professorLoggedIn(String Id) {
//		Logger logger = Logger.getLogger(ProfessorApplication.class);
//		ProfessorImplementation professorImplementation=new ProfessorImplementation();
		while(true) {
			System.out.println("1. Select Courses");//Selecting courses for Professor
			System.out.println("2. View Registered Courses");
			System.out.println("3. Add Grades");
			System.out.println("4. View Registered Students");
			
			System.out.println("Enter your option");
			Scanner sc = new Scanner(System.in);
			
			int option = sc.nextInt();
			
			switch (option) {
			case 1:
				addCourse();
				//Status of allotment to be added whether alloted or not.
				break;
			case 2:
				displayCourses();
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
				 ProfessorImplementation.viewCourse();
				 break;
			 case 5:
				 System.out.println("Enter  course Id");
				 courseId=sc.next();
				 ProfessorImplementation.viewRegisteredStudents(Id,courseId);
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

	private void addCourse(){
		System.out.println("Enter Course Code");
		String courseId = sc.next();

		//Course course = new Course(10, courseName, courseId);
		System.out.println("Enter Course name: ");
		String course_name = sc.next();
		AdminInterface.addCourse(course_name);
		System.out.println("Course added successfully");
	}

	private void displayCourses(){
		AdminInterface.displayCourses();
	}


}
