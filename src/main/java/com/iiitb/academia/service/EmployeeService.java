package com.iiitb.academia.service;

import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(int employeeId);

    List<Course> getCoursesByEmployeeId(int employeeId);
}
