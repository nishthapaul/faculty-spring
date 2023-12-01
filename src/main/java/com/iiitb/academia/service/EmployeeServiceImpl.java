package com.iiitb.academia.service;

import com.iiitb.academia.dao.CourseRepository;
import com.iiitb.academia.dao.EmployeeRepository;
import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CourseRepository courseRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if ( result.isPresent() ) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }
        return employee;
    }

    public List<Course> getCoursesByEmployeeId(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {
            return courseRepository.findByEmployee(employee);
        } else {
            return null;
        }
    }

}
