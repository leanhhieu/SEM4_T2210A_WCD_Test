package com.example.examwcd.service;

import com.example.examwcd.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int id);
    void addEmployee(Employee employee);
    void update(String id,Employee employee);

    void updateEmployee(String id, Employee employee);

    void deleteEmployeeById(String id);
}
