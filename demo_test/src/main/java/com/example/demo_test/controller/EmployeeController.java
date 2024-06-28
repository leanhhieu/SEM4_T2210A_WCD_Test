package com.example.demo_test.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model; // Correct import
import com.example.demo_test.entity.Employee;
import com.example.demo_test.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@GetMapping("")
    public String getAllEmployee(Model model){
    List<Employee> employees = employeeService.getAllEmployee();
    model.addAttribute("employees", employees);
        return "pages/employee";
    }
@GetMapping("/add")
    public String showFromAdd(Model model){
model.addAttribute("employee", new Employee());
List<Employee> employees = employeeService.getAllEmployee();
model.addAttribute("employees", employees);
        return "pages/addEmployee";
    }
    @PostMapping("/add")
    public String addEmployee(@Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "pages/addEmployee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model){
        Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "pages/editEmployee";
    }
    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable String id, @Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "pages/editEmployee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
@GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
