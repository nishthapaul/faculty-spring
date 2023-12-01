package com.iiitb.academia.service;

import com.iiitb.academia.dao.DepartmentRepository;
import com.iiitb.academia.dao.EmployeeRepository;
import com.iiitb.academia.entity.Department;
import com.iiitb.academia.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
