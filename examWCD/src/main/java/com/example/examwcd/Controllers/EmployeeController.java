package com.example.examwcd.Controllers;


import com.example.examwcd.entity.Employee;
import com.example.examwcd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
public final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> products = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeService);
        return "employees/index";
    }

    @GetMapping("add")
    public String add(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/add";
    }
    @PostMapping("add")
    public String add(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("update")
    public String editEmployee(Model model, int id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee");
        return "/employee/update";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("delete")
    public String delete(String id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
}
