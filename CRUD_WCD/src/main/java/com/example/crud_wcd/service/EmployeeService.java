package com.example.crud_wcd.service;

import com.example.crud_wcd.dao.IEmployeeDAO;
import com.example.crud_wcd.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(String id) {
        employeeDAO.deleteEmployee(id);
    }
}
