package com.flipkart.RestController;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import com.flipkart.exception.*;
import com.flipkart.service.*;
import com.flipkart.service.StudentImplementation;
import com.flipkart.service.StudentInterface;

import java.sql.SQLException;

@Path("/user")
    public class UserRestApi {
    UserInterface userInterface = new UserImplementation();
    StudentInterface studentInterface = new StudentImplementation();
    ProfessorInterface professorInterface = new ProfessorImplementation();

    /**
     * @param id:       id of the user
     * @param password: new password to be stored in db.
     * @return
     * @return @return 201, if password is updated, else 500 in case of error
     */
    @POST
    @Path("/updatePassword")
    public Response updatePassword(
            @NotNull

            @QueryParam("id") String id,
            @NotNull
            @Size(min = 4, max = 20, message = "Password length should be between 4 and 20 characters")
            @QueryParam("password") String password) {
        try{
            userInterface.updatePassword(id, password);
            return Response.status(201).entity("Password updated successfully! ").build();
        }catch(UserNotFoundException e){
            return Response.status(500).entity(e.getMessage()).build();
        }







    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(
            @QueryParam("id") String id,
            @QueryParam("role") String role,
            @QueryParam("password") String password) throws CourseNotFoundException, LoginFailedException,UserNotFoundException {

            if(userInterface.loginUser(id,password,role))
                return Response.status(201).entity(" login Successfully ").build();
            else
                return Response.status(500).entity("login Failed").build();
    }
}

