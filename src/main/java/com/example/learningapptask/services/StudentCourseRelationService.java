package com.example.learningapptask.services;

import com.example.learningapptask.datamodel.Repo.StudentCourseRelationRepo;
import com.example.learningapptask.datamodel.StudentCourseRelation;
import com.example.learningapptask.domain.EnrollCourseDTO;
import com.example.learningapptask.domain.dtoIn.StudentRegistrationDTOIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service

public class StudentCourseRelationService {
    @Autowired
    StudentCourseRelationRepo studentCourseRelationRepo;

    public StudentCourseRelation enrollStudentCourse(StudentRegistrationDTOIn studentRegistrationDTOIn) {
        StudentCourseRelation scr = new StudentCourseRelation();
        scr.setStudentId(studentRegistrationDTOIn.getStudentId());
        scr.setCourseId(studentRegistrationDTOIn.getCourseId());
        return studentCourseRelationRepo.save(scr);
    }
    public List<EnrollCourseDTO> enrollStudent(String email){
        //EnrollCourseDTO enrollCourseDTO = new EnrollCourseDTO();
        return studentCourseRelationRepo.findEnrollCourseDTOByEmail(email);
    }

    public int delCourseEntry(String studentId, String courseId) {
        StudentCourseRelation scr =new StudentCourseRelation();
        return studentCourseRelationRepo.deleteCourseByStudentIdAndCourseId(studentId,courseId);


    }
}
