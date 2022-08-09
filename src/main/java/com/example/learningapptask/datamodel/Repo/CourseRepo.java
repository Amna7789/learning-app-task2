package com.example.learningapptask.datamodel.Repo;

import com.example.learningapptask.datamodel.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CourseRepo extends PagingAndSortingRepository<Course,String> {
    Course deleteByCourseId(String courseId);
    Optional<Course> findByCourse(String course);


}
