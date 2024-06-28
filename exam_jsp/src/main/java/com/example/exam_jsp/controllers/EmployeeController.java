package com.example.exam_jsp.controllers;


import com.example.exam_jsp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
@MultipartConfig
public class EmployeeController extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && action.equals("edit")) {
            String employeeIdStr = req.getParameter("id");
            if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
                String employeeId = employeeIdStr;
                Employee employeeToEdit = entityManager.find(Employee.class, employeeId);
                if (employeeToEdit != null) {
                    req.setAttribute("employee", employeeToEdit);
                    req.getRequestDispatcher("/jsp/Employee/editEmployee.jsp").forward(req, resp);
                    return;
                }
            }
        }
        int page = 1;
        int pageSize = 5;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }


        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();


        long totalEmployees = (long) entityManager.createQuery("SELECT COUNT(e) FROM Employee e")
                .getSingleResult();
        int totalPages = (int) Math.ceil((double) totalEmployees / pageSize);

        // Set attributes for the request
        req.setAttribute("employees", employees);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);


        req.getRequestDispatcher("/jsp/Employee/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && action.equals("edit")) {
            String employeeIdStr = req.getParameter("id");
            if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
                String employeeId = employeeIdStr;

                entityManager.getTransaction().begin();

                Employee employeeToEdit = entityManager.find(Employee.class, employeeId);
                if (employeeToEdit != null) {
                    employeeToEdit.setEmployeeName(req.getParameter("employeeName"));
                    employeeToEdit.setBirthday(java.sql.Date.valueOf(req.getParameter("birthday")));
                    employeeToEdit.setPhoneNumber(req.getParameter("phoneNumber"));
                    employeeToEdit.setEmail(req.getParameter("email"));
                    entityManager.merge(employeeToEdit);
                }

                entityManager.getTransaction().commit();
            }

            resp.sendRedirect(req.getContextPath() + "/employee");
        } else if (action != null && action.equals("delete")) {
            String employeeIdStr = req.getParameter("id");
            if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
                String employeeId = employeeIdStr;

                entityManager.getTransaction().begin();

                Employee employeeToDelete = entityManager.find(Employee.class, employeeId);
                if (employeeToDelete != null) {
                    entityManager.remove(employeeToDelete);
                }

                entityManager.getTransaction().commit();
            }

            resp.sendRedirect(req.getContextPath() + "/employee");
        }
    }

    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
