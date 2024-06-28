package com.example.test;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Employee> employees = employeeDAO.searchEmployees(keyword);
        request.setAttribute("listEmployee", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);
    }
}