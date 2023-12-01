package com.iiitb.academia.service;

import com.iiitb.academia.entity.Department;
import com.iiitb.academia.entity.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
}
