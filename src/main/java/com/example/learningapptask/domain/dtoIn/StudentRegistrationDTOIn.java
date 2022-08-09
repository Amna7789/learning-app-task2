package com.example.learningapptask.domain.dtoIn;

public class StudentRegistrationDTOIn {
    String studentId;
    String courseId;

    public StudentRegistrationDTOIn() {
    }

    public StudentRegistrationDTOIn(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
