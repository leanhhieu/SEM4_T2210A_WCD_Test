package com.example.baithijpa.controllers;

import entity.Employee;
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
import java.util.List;

@WebServlet("/EditEmployee")
public class EditEmployeeController extends HttpServlet {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");  // Change 'id' to 'employeeId'
        if (employeeId == null || employeeId.isEmpty()) {
            request.getSession().setAttribute("message", "Invalid request. Employee ID is missing.");
            response.sendRedirect(request.getContextPath() + "/Employee");
            return;
        }

        Employee employee = entityManager.find(Employee.class, employeeId);
        if (employee != null) {
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/jsp/EditEmployee.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("message", "Employee not found");
            response.sendRedirect(request.getContextPath() + "/Employee");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        if (employeeId == null || employeeId.isEmpty()) {
            request.getSession().setAttribute("message", "Invalid request. Employee ID is missing.");
            response.sendRedirect(request.getContextPath() + "/Employee");
            return;
        }

        Employee employee = entityManager.find(Employee.class, employeeId);
        if (employee != null) {
            String employeeName = request.getParameter("employeeName");
            String birthdayString = request.getParameter("birthday");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");

            // Chuyển đổi từ chuỗi sang Date
            Date birthday = null;
            try {
                birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayString);
            } catch (ParseException e) {
                request.getSession().setAttribute("message", "Invalid date format.");
                response.sendRedirect(request.getContextPath() + "/EditEmployee?employeeId=" + employeeId);  // Change 'id' to 'employeeId'
                return;
            }

            // Cập nhật thông tin nhân viên
            employee.setEmployeeName(employeeName);
            employee.setBirthday(birthday);
            employee.setPhoneNumber(phoneNumber);
            employee.setEmail(email);

            // Bắt đầu giao dịch và lưu các thay đổi vào cơ sở dữ liệu
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();


            request.getSession().setAttribute("message", "Employee updated successfully.");
        } else {
            request.getSession().setAttribute("message", "Employee not found");
        }
        response.sendRedirect(request.getContextPath() + "/Employee");
    }

    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
