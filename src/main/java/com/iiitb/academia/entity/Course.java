package com.iiitb.academia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "academic_year")
    private int academic_year;

    @Column(name = "term")
    private int term;

    @Column(name = "credits")
    private int credits;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "faculty_id")
    @JsonBackReference
    private Employee employee;

    @OneToOne(mappedBy = "course")
    @JsonManagedReference
    private CourseSchedule courseSchedule;

    public Course() {}

    public Course(String courseCode, String name, String description, int academic_year, int term, int credits, int capacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.academic_year = academic_year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(int academic_year) {
        this.academic_year = academic_year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
}
