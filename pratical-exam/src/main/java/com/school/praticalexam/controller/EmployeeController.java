package com.school.praticalexam.controller;

import com.school.praticalexam.dto.request.EmployeeCreationRequest;
import com.school.praticalexam.entity.Employee;
import com.school.praticalexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    String getAllEmployee(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "pages/employees/index";
    }

    @GetMapping("/create")
    String addEmployee(Model model){
        model.addAttribute("employee", new EmployeeCreationRequest());
        return "pages/employees/add";
    }

    @PostMapping("/create")
    String addEmployee(@ModelAttribute EmployeeCreationRequest request){
        employeeService.saveEmployee(request);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    String editEmployee(@PathVariable String id, Model model){
        Employee Employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", Employee);
        return "pages/employees/edit";
    }

    @PostMapping("/edit/{id}")
    String updatedEmployee(@PathVariable String id,@ModelAttribute EmployeeCreationRequest request){
        employeeService.updateEmployee(id, request);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    String deleteEmployee(@PathVariable String id, RedirectAttributes redirectAttributes){
        var employee = employeeService.getEmployeeById(id);
//        var studentsbyClassRoomexist = studentRepository.findStudentsByClassRoom(employee);
//        if (studentsbyClassRoomexist.isEmpty()) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
//        }else {
//            redirectAttributes.addFlashAttribute("errMessage","Cannot delete employee by it has student");
//            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
//            return "redirect:/employee";
//        }
    }
}
