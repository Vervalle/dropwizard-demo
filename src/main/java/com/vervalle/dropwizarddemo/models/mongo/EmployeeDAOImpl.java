package com.vervalle.dropwizarddemo.models.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;


public class EmployeeDAOImpl extends BasicDAO<Employee, ObjectId> implements EmployeeDAO {

    public EmployeeDAOImpl(Class<Employee> entityClass, Datastore ds)  {
        super(entityClass, ds);
    }

    public Employee getByName(String name) {
        return createQuery().field("name").equal(name).get();
    }
}
