package com.example.exam_spring.controller;

import com.example.exam_spring.entity.Employee;
import com.example.exam_spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeConytroller {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeConytroller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "page/add_employee"; // This should be the name of your add form view
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "page/edit_employee";
    }
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@ModelAttribute Employee employee) {
        employeeService.deleteEmployee(employee.getId());
        return "redirect:/employee";
    }

    @GetMapping()
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "page/employee"; // Update this line
    }
}
