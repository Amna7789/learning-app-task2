package com.example.learningapptask.domain.dtoIn;

public class CourseDTOIn {
    String course;
    String courseId;
    String description;
    String author;

    public CourseDTOIn() {
    }

    public CourseDTOIn(String course, String courseId, String description, String author) {
        this.course = course;
        this.courseId = courseId;
        this.description = description;
        this.author = author;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
