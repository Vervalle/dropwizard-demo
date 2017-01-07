package com.vervalle.dropwizarddemo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.vervalle.dropwizarddemo.models.mongo.Employee;

import com.vervalle.dropwizarddemo.models.mongo.EmployeeDAO;
import com.vervalle.dropwizarddemo.models.mongo.EmployeeDAOImpl;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.List;


@Path("/mongodb/")
public class EmployeeResource {

    private Datastore db;
    private EmployeeDAOImpl employeeDAO;

    public EmployeeResource(Datastore database) {
        this.db = database;
        employeeDAO = new EmployeeDAOImpl(Employee.class, this.db);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> allEmployees() {
        Query<Employee> query = db.createQuery(Employee.class);
        List<Employee> employees = query.asList();
        return employees;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee create(Employee employee) {
        db.save(employee);
        return employee;
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findByName(@PathParam("name") String name) {
//        // without using DAO
//        Query<Employee> query = db.createQuery(Employee.class).field("name").equal(name);
//        return query.get();

        // with DAO
        Employee foundEmployee = employeeDAO.getByName(name);
        return foundEmployee;

    }

}
