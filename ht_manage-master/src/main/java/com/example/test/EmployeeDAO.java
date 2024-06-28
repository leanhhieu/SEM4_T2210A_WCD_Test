package com.example.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/hr_manage";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee (employee_id, employee_name, birthday, phone_number, email) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT employee_id, employee_name, birthday, phone_number, email FROM employee WHERE employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE employee_id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET employee_name = ?, birthday= ?, phone_number = ?, email = ? WHERE employee_id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setString(4, employee.getPhone_number());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Employee selectEmployee(String employee_id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setString(1, employee_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employee_name = rs.getString("employee_name");
                Date birthday = rs.getDate("birthday");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                employee = new Employee(employee_id, employee_name, birthday, phone_number, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String employee_name = rs.getString("employee_name");
                Date birthday = rs.getDate("birthday");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                employees.add(new Employee(employee_id, employee_name, birthday, phone_number, email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    public List<Employee> searchEmployees(String searchQuery) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE employee_id LIKE ? OR employee_name LIKE ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            String searchPattern = "%" + searchQuery + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String employee_name = rs.getString("employee_name");
                java.sql.Date birthday = rs.getDate("birthday");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                employees.add(new Employee(employee_id, employee_name, birthday, phone_number, email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    public boolean deleteEmployee(String employee_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setString(1, employee_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            statement.setString(1, employee.getEmployee_name());
            statement.setDate(2, employee.getBirthday());
            statement.setString(3, employee.getPhone_number());
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getEmployee_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
