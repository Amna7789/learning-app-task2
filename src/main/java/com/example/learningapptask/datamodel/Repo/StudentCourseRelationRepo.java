package com.example.learningapptask.datamodel.Repo;

import com.example.learningapptask.datamodel.StudentCourseRelation;
import com.example.learningapptask.domain.EnrollCourseDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCourseRelationRepo extends PagingAndSortingRepository<StudentCourseRelation, String> {
    @Query("SELECT new com.example.learningapptask.domain.EnrollCourseDTO( " +
            "s.id, s.name, s.email, c.courseId, c.course, c.description )FROM Student s INNER join StudentCourseRelation scr on s.id = scr.studentId " +
            "INNER join Course c on c.courseId = scr.courseId where email = :email")
    List<EnrollCourseDTO> findEnrollCourseDTOByEmail(@Param("email")String email);

    /*@Query("DELETE new com.example.learningapptask.domain.EnrollCourseDTO( " +
            "s.id, s.name, s.email, c.courseId, c.course, c.description )FROM Student s INNER join StudentCourseRelation scr on s.id = scr.studentId " +
            "INNER join Course c on c.courseId = scr.courseId where courseId = :courseId")
    EnrollCourseDTO deleteEnrollCourseDTOByCourseId(@Param("courseId")String courseId);*/
    int deleteCourseByStudentIdAndCourseId(String studentId, String courseId);
}
