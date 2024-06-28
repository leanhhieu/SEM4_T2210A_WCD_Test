package com.example.test;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employee_id = request.getParameter("employee_id");
        String employee_name = request.getParameter("employee_name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");

        Employee updatedEmployee = new Employee(employee_id, employee_name, birthday, phone_number, email);
        try {
            employeeDAO.updateEmployee(updatedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
