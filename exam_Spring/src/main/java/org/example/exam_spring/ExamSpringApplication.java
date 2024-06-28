package org.example.exam_spring;

import org.example.exam_spring.entity.Employee;
import org.example.exam_spring.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ExamSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamSpringApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(EmployeeService employeeService) {
        return args -> {
            getEmployeeById(employeeService);
            addNewEmployee(employeeService);
            updateEmployee(employeeService);
            deleteEmployee(employeeService);
        };
    }

    private static void addNewEmployee(EmployeeService employeeService) {
        Employee employee = new Employee();
        employee.setEmployee_name("A");
        employee.setEmail("1");
        employee.setEmployee_birthday(new Date());
        employee.setPhone_number("1");
        employeeService.saveEmployee(employee);
    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeById(1L);
        for (Employee e : employeeService.getAllEmployee()) {
            System.out.println(e.toString());
        }
    }

    private static void updateEmployee(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeById(1L);
        employee.setEmployee_name("B");
        employeeService.updateEmployee(1L, employee);
    }

    private static void deleteEmployee(EmployeeService employeeService) {
        employeeService.deleteEmployee(1L);
    }
}
