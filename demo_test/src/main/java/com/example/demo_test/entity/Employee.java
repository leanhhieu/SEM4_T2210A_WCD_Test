package com.example.demo_test.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @NotEmpty(message = "Employee name must not be empty")
    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false)
    private String email;


    public Employee() {
    }
    public Employee(String employeeId, String employeeName, Date birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
