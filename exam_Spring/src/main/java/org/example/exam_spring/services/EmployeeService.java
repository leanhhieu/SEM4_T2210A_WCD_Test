package org.example.exam_spring.services;

import org.example.exam_spring.entity.Employee;
import org.example.exam_spring.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElse(null);
        if (employee1 != null) {
            employee1.setEmployee_id(employee.getEmployee_id());
            employee1.setEmployee_name(employee.getEmployee_name());
            employee1.setEmail(employee.getEmail());
            employee1.setEmployee_birthday(employee.getEmployee_birthday());
            employee1.setPhone_number(employee.getPhone_number());
            employeeRepository.save(employee1);
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee with id " + id + " has been deleted.";
    }
}
