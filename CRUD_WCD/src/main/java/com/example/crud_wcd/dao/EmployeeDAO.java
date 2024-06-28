package com.example.crud_wcd.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.example.crud_wcd.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        if (employee.getEmployeeId() == null) {
            entityManager.persist(employee);
        } else {
            entityManager.merge(employee);
        }
    }

    @Override
    public Employee getEmployeeById(String id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteEmployee(String id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
