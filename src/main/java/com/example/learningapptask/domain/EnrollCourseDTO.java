package com.example.learningapptask.domain;

public class EnrollCourseDTO {
    String studentId;
    String name;
    String email;
    String courseId;
    String course;
    String description;

    public EnrollCourseDTO() {
    }

    public EnrollCourseDTO(String studentId, String name, String email, String courseId, String course, String description) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.courseId = courseId;
        this.course = course;
        this.description = description;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
