package com.example.crud_wcd.service;

import com.example.crud_wcd.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(String id);
}
