package com.vervalle.dropwizarddemo.resources;

/*
this resources graps the parameter from the URL
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/greetings/{name}")
public class GreetingsResource {

    @GET
    public String getGreeting(@PathParam("name") String name) {
        return "Bonjour, " + name + "!";
    }

}
