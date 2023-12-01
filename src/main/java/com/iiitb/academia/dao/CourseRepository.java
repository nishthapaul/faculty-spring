package com.iiitb.academia.dao;

import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByEmployee(Employee employee);
    List<Course> findByEmployeeIsNull();
}
