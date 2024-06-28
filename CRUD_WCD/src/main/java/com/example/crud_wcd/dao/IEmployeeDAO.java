package com.example.crud_wcd.dao;

import com.example.crud_wcd.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployees();
    void deleteEmployee(String id);
}
