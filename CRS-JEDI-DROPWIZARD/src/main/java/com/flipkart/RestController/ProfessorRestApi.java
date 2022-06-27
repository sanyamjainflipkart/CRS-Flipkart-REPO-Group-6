package com.flipkart.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.service.ProfessorImplementation;
import com.flipkart.service.ProfessorInterface;
@Path("/professor")
public class ProfessorRestApi {
    @POST
    @Path("/addGrades")
    public Response addGrade(@NotNull @QueryParam("courseId") String courseId,
                              @NotNull @QueryParam("studentId") String studentId , @NotNull @QueryParam("grade") String grade)
    {
        System.out.println(courseId+" "+studentId+" "+grade);
        ProfessorInterface p = new ProfessorImplementation();
        if( p.addGrade(studentId,courseId,grade))
        {
            return Response.status(201).entity("Grade "+ grade +" added Succesfully to studentID "
                    + studentId +"in CourseId  "+ courseId ).build();
        }else {
            return Response.status(500).entity("Unable to add grades").build();
        }
    }

    @GET
    @Path("/viewRegisteredStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public void viewRegisteredStudents(@NotNull @QueryParam("profId") String profId , @NotNull @QueryParam("courseId") String courseId)
    {
        ProfessorInterface p = new ProfessorImplementation();
        p.viewRegisteredStudents(profId,courseId);
    }

    @GET
    @Path("/viewRegisteredCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public void viewRegisterdCourses()
    {
        ProfessorInterface p = new ProfessorImplementation();
        p.viewRegisteredCourses();
    }
    @POST
    @Path("/registerCourse")
    public Response registerCourse(@NotNull @QueryParam("profId") String profId , @NotNull @QueryParam("courseId") String courseId)
    {
        ProfessorInterface p = new ProfessorImplementation();
        if(p.registerCourse(profId,courseId))
        {
                return Response.status(201).entity("Course has been registered").build();
        }
        else {
            return Response.status(500).entity("Cannot Register For This Course").build();
        }
    }
}