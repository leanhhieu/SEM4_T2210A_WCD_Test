package org.fai.example.demo_spring_01.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id_employee;
    @Column (name = "employee_name")
    private String employee_name;
    @Column(name = "number_employee")
    private Integer number_employee;
    @Column(name = "birthday")
    private String Birthday;
    @Column(name = "email")
    private String email;

    public Integer getId_class() {
        return id_class;
    }

    public void setId_class(Integer id_class) {
        this.id_class = id_class;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getNumber_member() {
        return number_member;
    }

    public void setNumber_member(Integer number_member) {
        this.number_member = number_member;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company(Integer id_employee, String employee_name, Integer number_employee, String Birthday, String email ) {
        this.id_employee = id_employee;
        this.employee_name = employee_name;
        this.number_employee = number_employee;
        this.Birthday = Birthday;
        this.email = email;
    }

    public ClassRoom() {}

    @Override
    public String toString() {
        return "Company{" +
                "id_employee=" + id_employee +
                ", employee_name='" + employee_name + '\'' +
                ", number_employee=" + number_employee +
                ", Birthday='" + Birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
