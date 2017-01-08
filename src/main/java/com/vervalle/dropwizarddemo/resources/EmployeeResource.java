package com.vervalle.dropwizarddemo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.vervalle.dropwizarddemo.models.mongo.Employee;

import com.vervalle.dropwizarddemo.models.mongo.EmployeeRepositoryImpl;
import org.mongodb.morphia.Datastore;

import java.util.List;


@Path("/employees/")
public class EmployeeResource {

    private Datastore db;
    private EmployeeRepositoryImpl repository;

    public EmployeeResource(Datastore database) {
        this.db = database;
        repository = new EmployeeRepositoryImpl(Employee.class, this.db);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> allEmployees() {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee create(Employee employee) {
        return repository.insert(employee);
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findByName(@PathParam("name") String name) {
        return repository.getByName(name);
    }

}
