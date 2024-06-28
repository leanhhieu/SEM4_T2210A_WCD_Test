package com.example.exam_jsp.controllers;

import com.example.exam_jsp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/Employee/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("employeeId");
        String employeeName = req.getParameter("employeeName");
        String birthdayStr = req.getParameter("birthday"); // Get birthday as String
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        Date birthday = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Specify your date format
            birthday = dateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId); // Set employee ID from user input
        employee.setEmployeeName(employeeName);
        employee.setBirthday(birthday);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        resp.sendRedirect(req.getContextPath() + "/employee");
    }

    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
