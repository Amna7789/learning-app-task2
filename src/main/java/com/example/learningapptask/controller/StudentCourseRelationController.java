package com.example.learningapptask.controller;

import com.example.learningapptask.datamodel.StudentCourseRelation;
import com.example.learningapptask.domain.EnrollCourseDTO;
import com.example.learningapptask.domain.dtoIn.StudentRegistrationDTOIn;

import com.example.learningapptask.services.StudentCourseRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCourseRelationController {
    @Autowired
    StudentCourseRelationService studentCourseRelationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/enrollStudentCourse")
    public StudentCourseRelation enrollStudentCourse(@RequestBody StudentRegistrationDTOIn studentRegistrationDTOIn){
         return studentCourseRelationService.enrollStudentCourse(studentRegistrationDTOIn);

    }
    @GetMapping("/enrollStudent")
    public List<EnrollCourseDTO> enrollStudentInCourse(@RequestParam("email") String email){
        return studentCourseRelationService.enrollStudent(email);

    }
    @DeleteMapping("/delCourseEntry")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourseEntry(@RequestParam("studentId")String studentId,
                                                   @RequestParam("courseId")String courseId){
        studentCourseRelationService.delCourseEntry(studentId,courseId);
    }

}
