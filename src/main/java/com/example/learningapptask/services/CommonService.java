package com.example.learningapptask.services;

import com.example.learningapptask.datamodel.Repo.CourseRepo;
import com.example.learningapptask.datamodel.Repo.StudentCourseRelationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    StudentCourseRelationRepo studentCourseRelationRepo;
    @Autowired
    CourseRepo courseRepo;


}
