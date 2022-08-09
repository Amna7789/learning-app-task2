package com.example.learningapptask.controller;

import com.example.learningapptask.datamodel.Course;
import com.example.learningapptask.domain.CourseDTO;
import com.example.learningapptask.domain.dtoIn.CourseDTOIn;
import com.example.learningapptask.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/getCourses")
    public List<Course> getCourses(){
        return courseService.getAllCourses();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createCourse")
    //creating new course using DTOIn(long procedure)
    public CourseDTO createNewCourse(@RequestBody CourseDTOIn courseDTOIn){
        return courseService.createCourse(courseDTOIn);
    }
    //here we are creating new course with short procedure(just 4 lines of code)
    /*public void createNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }*/

    //updating course using simple and easy procedure that is similar to post

    @PutMapping("/updateCourse/{courseId}")
    /*public Course update(@RequestBody Course course){
       return courseService.updateCourse(course);
    }*/
    public void updateCourse(@PathVariable("courseId") String courseId, @RequestBody CourseDTOIn courseDTOIn){
         courseService.updateCourseById(courseId, courseDTOIn);
    }


   /* @DeleteMapping("/deleteCourse")
   public void delCourse(@RequestBody CourseDTOIn courseDTOIn){
          courseService.deleteCourse(courseDTOIn);

    }*/
    //deleting course using weird method
    @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable String id){
         courseService.delete(id);
    }

    /*@GetMapping("/searchCourse/{id}")
    public Optional<Course> searchCourseId(@PathVariable("id") String id){
       return courseService.searchingCourseId(id);
    }*/

 /* @GetMapping("/searchCourse/{course}")
    public Optional<Course> searchCourseName(@PathVariable("course")String course){
        return courseService.searchingCourseName(course);*/
    @GetMapping("/courseSearching")
    public Optional<Course> getCourseName(@RequestParam(value="name", required = false) String name,
                                          @RequestParam(value = "id",required = false) String id){
       return courseService.searchingCourse(name,id);
    }

}
