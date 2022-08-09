package com.example.learningapptask.domain;

import com.example.learningapptask.domain.dtoIn.StudentRegistrationDTOIn;

public class StudentRegistrationDTO extends StudentRegistrationDTOIn {
    public StudentRegistrationDTO() {
    }

    public StudentRegistrationDTO(String id, String courseId) {
        super(id, courseId);
    }
}
