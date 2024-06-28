package org.example.exam_spring.services;

import org.example.exam_spring.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public void saveEmployee(Employee employee);
    public void updateEmployee(Long id,Employee employee);
    public String deleteEmployee(Long id);
}
