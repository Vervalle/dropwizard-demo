package com.vervalle.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/echo")
@Produces(MediaType.TEXT_PLAIN)
public class EchoResource {

    @GET
    @Timed
    public String getEcho(@QueryParam("echo") String echo) {
        if (echo.length() < 1) {
            throw new NotFoundException();
        } else {
            return echo;
        }
    }
}
