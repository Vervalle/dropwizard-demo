package com.vervalle.dropwizarddemo.models.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

import java.util.List;

public interface EmployeeRepository extends DAO<Employee, ObjectId> {

    Employee getByName(String name);

    Employee insert(Employee employee);

    List<Employee> findAll();


}
