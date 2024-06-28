package com.school.praticalexam.service;

import com.school.praticalexam.dto.request.EmployeeCreationRequest;
import com.school.praticalexam.entity.Employee;
import com.school.praticalexam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee saveEmployee(EmployeeCreationRequest request) {
        Employee Employee = new Employee();
        Employee.setEmployee_id(request.getEmployee_id());
        Employee.setEmployee_name(request.getEmployee_name());
        Employee.setEmail(request.getEmail());
        Employee.setPhone_number(request.getPhone_number());
        Employee.setBirthday(request.getBirthday());

        return employeeRepository.save(Employee);
    }

    public Employee updateEmployee(String id, EmployeeCreationRequest request) {
        Employee Employee = getEmployeeById(id);
        Employee.setEmployee_id(request.getEmployee_id());
        Employee.setEmployee_name(request.getEmployee_name());
        Employee.setEmail(request.getEmail());
        Employee.setPhone_number(request.getPhone_number());
        Employee.setBirthday(request.getBirthday());
        return employeeRepository.save(Employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
