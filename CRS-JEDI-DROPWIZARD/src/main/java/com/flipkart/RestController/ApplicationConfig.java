package com.flipkart.RestController;

import org.glassfish.jersey.server.ResourceConfig;


public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(StudentRestApi.class);
        register(AdminRestApi.class);
        register(UserRestApi.class);
        register(ProfessorRestApi.class);
    }
}
