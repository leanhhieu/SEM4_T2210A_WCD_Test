package com.example.examwcd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    public int employee_id;

    @Column(name = "employee_name")
    public String employee_name;

    @Column(name = "birthday")
    public String birthday;

    @Column(name = "phone_number")
    public String phone_number;

    @Column(name = "email")
    public String email;

    public Employee() {}

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "birthday='" + birthday + '\'' +
                ", employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void getEmployee_name(Object employeeName) {
    }

    public void getPhone_number(Object phoneNumber) {
    }
}
