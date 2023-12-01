package com.iiitb.academia.dao;

import com.iiitb.academia.entity.Department;
import com.iiitb.academia.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
