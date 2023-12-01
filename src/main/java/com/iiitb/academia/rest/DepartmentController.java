package com.iiitb.academia.rest;

import com.iiitb.academia.entity.Department;
import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.service.DepartmentService;
import com.iiitb.academia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.findAll();
    }
}
