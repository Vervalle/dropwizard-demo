package com.vervalle.dropwizarddemo.models.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import java.util.List;


public class EmployeeRepositoryImpl extends BasicDAO<Employee, ObjectId> implements EmployeeRepository {

    public EmployeeRepositoryImpl(Class<Employee> entityClass, Datastore ds)  {
        super(entityClass, ds);
    }

    public Employee getByName(String name) {
        return createQuery().field("name").equal(name).get();
    }

    public Employee insert(Employee employee) {
        save(employee);
        return  employee;
    }

    public List<Employee> findAll() {
        Query<Employee> query = createQuery();
        return query.asList();
    }
}
