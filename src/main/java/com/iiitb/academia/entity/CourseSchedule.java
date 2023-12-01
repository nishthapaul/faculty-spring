package com.iiitb.academia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "course_schedule")
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_schedule_id")
    private int courseScheduleId;

    @OneToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "class_day")
    private String classDay;

    @Column(name = "room")
    private int room;

    @Column(name = "building")
    private String building;

    public CourseSchedule() {}

    public CourseSchedule(String startTime, String endTime, String classDay, int room, String building) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.classDay = classDay;
        this.room = room;
        this.building = building;
    }

    public int getCourseScheduleId() {
        return courseScheduleId;
    }

    public void setCourseScheduleId(int courseScheduleId) {
        this.courseScheduleId = courseScheduleId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
