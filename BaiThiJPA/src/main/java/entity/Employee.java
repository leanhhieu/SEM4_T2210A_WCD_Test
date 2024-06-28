package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id", length = 20)
    private String employeeId;

    @Column(name = "employee_name", length = 64)
    private String employeeName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "email", length = 255)
    private String email;

    // Constructors
    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Date birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
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

    // toString method (optional for printing object details)
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
