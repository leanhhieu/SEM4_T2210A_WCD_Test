package com.example.exam_spring.dao;

import com.example.exam_spring.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAO implements IEmployeeDAO {
    public final EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return this.entityManager.createQuery("from Employee ").getResultList();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            this.entityManager.remove(employee);
        }
    }
}
