package com.example.learningapptask.datamodel.Repo;

import com.example.learningapptask.datamodel.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {

    Student findByEmailAndPassword(String email, String password);
    
}
