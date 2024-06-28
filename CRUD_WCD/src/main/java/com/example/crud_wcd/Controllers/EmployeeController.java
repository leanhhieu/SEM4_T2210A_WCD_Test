package com.example.crud_wcd.Controllers;

import com.example.crud_wcd.entity.Employee;
import com.example.crud_wcd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee/edit";
        } else {
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setBirthday(employee.getBirthday());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setEmail(employee.getEmail());
            employeeService.saveEmployee(existingEmployee);
        }
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable("id") String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee/view";
        } else {
            return "redirect:/employee/list";
        }
    }
}
