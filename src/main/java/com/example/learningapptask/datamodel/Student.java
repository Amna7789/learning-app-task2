package com.example.learningapptask.datamodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
    @Id
    String id;
    String name;
    String email;
    @Column(name = "phoneno")
    String phoneNo;
    String courseId;
    String courseName;

    String password;

    public Student() {
    }

    public Student(String id, String name, String email, String phoneNo, String courseId, String courseName, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.courseId = courseId;
        this.courseName = courseName;
        this.password = password;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
