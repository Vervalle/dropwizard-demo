package com.vervalle.dropwizarddemo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vervalle.dropwizarddemo.SampleApplication;
import com.vervalle.dropwizarddemo.models.mongo.Employee;

import com.vervalle.dropwizarddemo.models.mongo.EmployeeRepositoryImpl;
import org.mongodb.morphia.Datastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Path("/employees/")
public class EmployeeResource {

    private Datastore db;
    private EmployeeRepositoryImpl repository;

    public EmployeeResource(Datastore database) {
        this.db = database;
        repository = new EmployeeRepositoryImpl(Employee.class, this.db);
    }

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allEmployees() {
        return Response.ok(repository.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Employee employee) {
        // validation
        if (employee.getName() == null) {
            LOGGER.error(String.format("@POST - insert - invalid data: %s ", employee));
            return Response.status(Response.Status.BAD_REQUEST).entity(employee).build();
        } else {
            return Response.ok(repository.insert(employee)).build();
        }
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        Employee employee = repository.getByName(name);
        if (employee != null)
            return Response.ok(employee).build();
        else {
            LOGGER.error(String.format("@GET - findByName - employee %s NOT FOUND", name));
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
