package com.example.exam_spring.service;

import com.example.exam_spring.dao.IEmployeeDAO;
import com.example.exam_spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final IEmployeeDAO employeeDAO;
    @Autowired
    public EmployeeService(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }
    public Employee getEmployeeById(Integer id){
        return employeeDAO.getEmployeeById(id);
    }
    public void updateEmployee(Employee employee){
        employeeDAO.updateEmployee(employee);
    }
    public void deleteEmployee(Integer id){
        employeeDAO.deleteEmployee(id);
    }
    public List<Employee> getAllEmployee(){
        return employeeDAO.getAllEmployee();
    }

}
