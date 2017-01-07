package com.vervalle.dropwizarddemo.models.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface EmployeeDAO extends DAO<Employee, ObjectId> {

    Employee getByName(String name);

    Employee insert(Employee employee);


}
