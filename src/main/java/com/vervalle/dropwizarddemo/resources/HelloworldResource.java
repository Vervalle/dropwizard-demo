package com.vervalle.dropwizarddemo.resources;

/*
this resources requires configuration.yml to get the message to display
URI is localhost:8080/hello
 */

import com.vervalle.dropwizarddemo.models.Messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value = "/hello")
public class HelloworldResource {

    private final Messages conf;

    public HelloworldResource(Messages conf) {
        this.conf = conf;
    }

    @GET
    public String sayHello() {
        return conf.getHello();
    }

}
