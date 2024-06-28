package com.example.demo_test.service;

import com.example.demo_test.entity.Employee;
import com.example.demo_test.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
   private EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
public List<Employee> getAllEmployee() {
    return employeeRepo.findAll();
}
public Optional<Employee> getEmployeeById(String id) {
    return employeeRepo.findById(id);
}
public Employee saveEmployee(Employee employee) {
    return employeeRepo.save(employee);
}
public void deleteEmployee(String id) {
    employeeRepo.deleteById(id);
}
}
