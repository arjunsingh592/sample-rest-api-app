package com.example.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/greetings")  // Base URI path
@Produces(MediaType.APPLICATION_JSON)  // Default response type
@Consumes(MediaType.APPLICATION_JSON)  // For POST
public class GreetingResource {

    // Simple POJO for JSON
    public static class Greeting {
        private String message;

        public Greeting() {}  // Needed for JSON deserialization

        public Greeting(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @GET
    @Path("/hello")
    public Greeting sayHello() {
        return new Greeting("Hello from RESTful Service!");
    }

    @GET
    @Path("/hello/{name}")
    public Greeting sayHelloTo(@PathParam("name") String name) {
        return new Greeting("Hello, " + name + "!");
    }

    @POST
    @Path("/echo")
    public Response echo(Greeting input) {
        return Response.ok(new Greeting("Echo: " + input.getMessage())).build();
    }
}