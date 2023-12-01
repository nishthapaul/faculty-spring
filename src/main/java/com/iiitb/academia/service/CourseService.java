package com.iiitb.academia.service;

import com.iiitb.academia.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCoursesWithoutEmployee();
    void updateCourseWithEmployee(int courseId, int employeeId);

}
