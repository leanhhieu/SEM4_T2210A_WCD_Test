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
import java.util.List;

@WebServlet("/Employee")
public class EmployeeController extends HttpServlet {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("/jsp/Employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            String employeeId = request.getParameter("id");
            if (employeeId != null) {
                entityManager.getTransaction().begin();
                Employee employee = entityManager.find(Employee.class, employeeId);
                if (employee != null) {
                    entityManager.remove(employee);
                    entityManager.getTransaction().commit();
                    request.getSession().setAttribute("message", "Employee deleted successfully.");
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/Employee"); // Redirect to doGet method
    }

    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
