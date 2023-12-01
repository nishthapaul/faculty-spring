package com.iiitb.academia.rest;

import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/employees/null")
    public List<Course> getCoursesWithoutEmployee() {
        return courseService.getCoursesWithoutEmployee();
    }

    @PutMapping("/courses/{courseId}/employees/{employeeId}")
    public void updateCoursesWithFaculty(@PathVariable int courseId, @PathVariable int employeeId) {
        courseService.updateCourseWithEmployee(courseId, employeeId);
//        try {
//            // Fetch the course and employee from the database
//            Course course = courseService.findById(courseId);
//            Employee employee = courseService.getEmployeeById(employeeId);
//
//            // Check for schedule conflicts
//            if (!courseService.hasScheduleConflicts(course, employee)) {
//                // No conflicts, update the course with the faculty
//                courseService.updateCourseWithEmployee(courseId, employeeId);
//                return ResponseEntity.ok("Faculty assigned to the course successfully.");
//            } else {
//                // Handle schedule conflicts
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Schedule conflict detected. Faculty has overlapping courses.");
//            }
//        } catch (RuntimeException e) {
//            // Handle exceptions, log errors, or return an appropriate response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
//        }
    }
}
