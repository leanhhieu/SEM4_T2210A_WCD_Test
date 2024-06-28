package com.example.exam_spring.dao;

import com.example.exam_spring.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    void  saveEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployee();
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
