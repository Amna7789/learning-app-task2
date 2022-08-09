package com.example.learningapptask.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

    String course;
    @Id
    @Column(name = "courseid")
    String courseId;
    String description;
    String author;

    public Course() {
    }

    public Course(String course, String courseId, String desc, String author) {
        this.course = course;
        this.courseId = courseId;
        this.description = desc;
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
