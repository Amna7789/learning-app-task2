package com.example.learningapptask.controller;

import com.example.learningapptask.datamodel.Student;
import com.example.learningapptask.domain.LoginDTO;
import com.example.learningapptask.domain.dtoIn.LoginDTOIn;
import com.example.learningapptask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student){
        studentService.createNewStudent(student);
    }
    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return studentService.allStudents();
    }
    //ye chez puchni hai
    @DeleteMapping("/deletingCourse/{id}")
    public String deleteCourse(@PathVariable String id){
        return studentService.deleteCourse(id);
    }

    @GetMapping("/login")
    public List<Student> matchStudents(@RequestParam("email")String email,
                                       @RequestParam("password")String password){
        return studentService.Students(email,password);
    }

    @GetMapping("/signin")
    public LoginDTO matchStudents(@RequestBody LoginDTOIn loginDTOIn) {
        return studentService.login(loginDTOIn);
    }
}
