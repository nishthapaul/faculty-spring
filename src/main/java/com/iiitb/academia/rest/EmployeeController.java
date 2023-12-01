package com.iiitb.academia.rest;

import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.exceptions.DuplicateEmailException;
import com.iiitb.academia.exceptions.EmployeeNotFoundException;
import com.iiitb.academia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee Employee = employeeService.findById(employeeId);
        if ( Employee == null ) {
            throw new EmployeeNotFoundException("Employee with Employee Id : " + employeeId + " not found");
        }
        return Employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employee.setEmployeeId(0);
        try {
            Employee dbEmployee = employeeService.save(employee);
            return new ResponseEntity<>(dbEmployee, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateEmailException("Email is already in use", ex);
        }
    }

    @GetMapping("/employees/{employeeId}/courses")
    public List<Course> getCoursesByEmployeeId(@PathVariable int employeeId) {
        return employeeService.getCoursesByEmployeeId(employeeId);
    }

}
