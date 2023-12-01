package com.iiitb.academia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "title")
    private String title;
    @Column(name = "photograph_path")
    private String photographPath;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String title, String photographPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.photographPath = photographPath;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
