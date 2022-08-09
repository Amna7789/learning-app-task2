package com.example.learningapptask.domain;

import com.example.learningapptask.domain.dtoIn.CourseDTOIn;

public class CourseDTO  extends CourseDTOIn {

    String course;
    String courseId;
    String description;
    String author;

    public CourseDTO() {
    }

    public CourseDTO(String course, String courseId, String description, String author) {
        super(course, courseId, description, author);
    }

    @Override
    public String getCourse() {
        return course;
    }

    @Override
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String getCourseId() {
        return courseId;
    }

    @Override
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
}
