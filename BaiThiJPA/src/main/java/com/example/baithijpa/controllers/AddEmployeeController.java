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

@WebServlet("/AddEmployee")
public class AddEmployeeController extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/AddEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ request
        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String birthdayStr = request.getParameter("birthday");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        Date birthday = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthday = dateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Tạo một đối tượng Employee mới
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeId(employeeId);
        newEmployee.setEmployeeName(employeeName);
        newEmployee.setBirthday(birthday);
        newEmployee.setPhoneNumber(phoneNumber);
        newEmployee.setEmail(email);

        // Bắt đầu một giao dịch
        entityManager.getTransaction().begin();
        // Lưu đối tượng mới vào cơ sở dữ liệu
        entityManager.persist(newEmployee);
        // Kết thúc giao dịch
        entityManager.getTransaction().commit();

        // Lưu thông báo vào session
        request.getSession().setAttribute("message", "Employee added successfully");

        // Chuyển hướng về trang chính
        response.sendRedirect(request.getContextPath() + "/Employee");
    }

    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
