package com.example.examwcd.service;

import com.example.examwcd.dao.IEmployeeReponsitory;
import com.example.examwcd.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class EmployeeService implements IEmployeeService {
    private final IEmployeeReponsitory employeeReponsitory;
    @Autowired
    public EmployeeService(IEmployeeReponsitory employeeReponsitory) {
        this.employeeReponsitory = employeeReponsitory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeReponsitory.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeReponsitory.findById(id);
    }

    @Override
    public void addEmployee (Employee employee) {
        employeeReponsitory.save(employee);
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
        var existingEmployeeOptional = getEmployeeById(Integer.parseInt(id));
        if(existingEmployeeOptional.isPresent()){
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.getEmployee_name(employee.getEmployee_name());
            existingEmployee.setBirthday(employee.getBirthday());
            existingEmployee.getPhone_number(employee.getPhone_number());
            existingEmployee.setEmail(employee.getEmail());
            employeeReponsitory.save(existingEmployee);
        }
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeReponsitory.deleteById(Integer.valueOf(id));
    }

    public void update(Employee employee) {
    }
}
