package com.example.learningapptask.services;

import com.example.learningapptask.datamodel.Course;
import com.example.learningapptask.datamodel.Repo.CourseRepo;
import com.example.learningapptask.domain.CourseDTO;
import com.example.learningapptask.domain.dtoIn.CourseDTOIn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

     public CourseDTO createCourse(CourseDTOIn courseDTOIn) {
         /*Course course = new Course();
         //using getter and setter
         course.setCourse(courseDTOIn.getCourse());
         course.setCourseId(UUID.randomUUID().toString());
         course.setAuthor(courseDTOIn.getAuthor());
         course.setDescription(courseDTOIn.getDescription());*/
         //using ModelMapper to get rid of getter and setter
         Course c = new Course();

         ModelMapper mp = new ModelMapper();
         courseDTOIn.setCourseId(UUID.randomUUID().toString());
         Course course = mp.map(courseDTOIn, Course.class);

         courseRepo.save(course);
         CourseDTO courseDTO =mp.map(course,CourseDTO.class);
         return courseDTO;



     }
   /* public void createCourse(Course course) {
        course.setCourseId(UUID.randomUUID().toString());
        courseRepo.save(course);
    }*/

    public List<Course> getAllCourses() {
        Iterable<Course> iterable = courseRepo.findAll();
        Iterator<Course> iterator = iterable.iterator();
        List<Course> allCourses = new ArrayList<>();
        while (iterator.hasNext()) {
            allCourses.add(iterator.next());
        }
        return allCourses;
    }

    /*public Course updateCourse(Course course) {
        return courseRepo.save(course);

    }*/
    public void updateCourseById(String courseId, CourseDTOIn courseDTOIn) {
        //Amna's correct method
        /*if( ! courseId.equals(courseDTOIn.getCourseId()))
            throw new InputMismatchException("Input is not correct");

        Course course = new Course();
        course.setCourse(courseDTOIn.getCourse());
        course.setCourseId(courseId);
        course.setDescription(courseDTOIn.getDescription());
        course.setAuthor(courseDTOIn.getAuthor());
        Course updateCourse = courseRepo.save(course);*/

        //Usman's correct method
        Optional<Course> course = courseRepo.findById(courseId);
        if(course.isEmpty()) {
            throw new IllegalArgumentException("Invalid id");
        }
        ModelMapper mp = new ModelMapper();
        Course updatedCourse= course.get();
        mp.map(courseDTOIn,updatedCourse);
        courseRepo.save(updatedCourse);

    }

    public void delete(@PathVariable String id) {
        //Amna's correct method(return type of method was String)
       /* Optional<Course> course = courseRepo.findById(id);

        if (course.isPresent()) {
            courseRepo.delete(course.get());
        }
        return "Course is deleted " + id;*/
        //Usman's correct method
        Optional<Course> course = courseRepo.findById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException();
        }
        courseRepo.deleteById(id);
    }

  /* public void deleteCourse(CourseDTOIn courseDTOIn) {
        courseRepo.deleteByCourseId(courseDTOIn.getCourseId());
    }*/


    public Optional<Course> searchingCourseId(String id) {
        Optional<Course> course = courseRepo.findById(id);
        return course;
    }

    public Optional<Course> searchingCourseName(String course) {
        Optional<Course> course1 = courseRepo.findByCourse(course);
        return course1;
    }

    public Optional<Course> searchingCourse(String name, String id) {
        if (name != null) {
            return courseRepo.findByCourse(name);
        }
        return courseRepo.findById(id);


    }


}
