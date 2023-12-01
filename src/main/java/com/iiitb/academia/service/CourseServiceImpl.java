package com.iiitb.academia.service;

import com.iiitb.academia.dao.CourseRepository;
import com.iiitb.academia.dao.EmployeeRepository;
import com.iiitb.academia.entity.Course;
import com.iiitb.academia.entity.CourseSchedule;
import com.iiitb.academia.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, EmployeeRepository employeeRepository) {
        this.courseRepository = courseRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Course> getCoursesWithoutEmployee() {
        return courseRepository.findByEmployeeIsNull();
    }

    @Override
    public void updateCourseWithEmployee(int courseId, int employeeId) {
        Optional<Employee> employeeResult = employeeRepository.findById(employeeId);
        Employee employee = null;
        Course course = null;
        if ( employeeResult.isPresent() ) {
            employee = employeeResult.get();
            Optional<Course> courseResult = courseRepository.findById(courseId);
            if ( courseResult.isPresent() ) {
                course = courseResult.get();

                if ( !hasScheduleConflicts(course, employee) ) {
                    course.setEmployee(employee);
                    courseRepository.save(course);
                } else {
                    throw new RuntimeException("Conflict");
                }
            } else {
                throw new RuntimeException("Did not find Course Id - " + courseId);
            }
        } else {
            throw new RuntimeException("Did not find Employee Id - " + employeeId);
        }
    }

    public boolean hasScheduleConflicts(Course newCourse, Employee faculty) {
        List<Course> facultyCourses = courseRepository.findByEmployee(faculty);

        for (Course existingCourse : facultyCourses) {
            if (doSchedulesOverlap(existingCourse.getCourseSchedule(), newCourse.getCourseSchedule())) {
                return true; // Schedule conflict detected
            }
        }

        return false; // No conflicts found
    }

//    @Override
//    public Course findById(int courseId) {
//        Optional<Course> courseResult = courseRepository.findById(courseId);
//        Course course = null;
//        if ( courseResult.isPresent() ) {
//            course = courseResult.get();
//        } else {
//            throw new RuntimeException("Did not find Course Id - " + courseId);
//        }
//        return course;
//    }

    private boolean doSchedulesOverlap(CourseSchedule schedule1, CourseSchedule schedule2) {
        LocalTime startTime1 = LocalTime.parse(schedule1.getStartTime());
        LocalTime endTime1 = LocalTime.parse(schedule1.getEndTime());

        LocalTime startTime2 = LocalTime.parse(schedule2.getStartTime());
        LocalTime endTime2 = LocalTime.parse(schedule2.getEndTime());

        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }
}
