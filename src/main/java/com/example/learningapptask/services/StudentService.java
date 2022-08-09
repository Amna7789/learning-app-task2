package com.example.learningapptask.services;

import com.example.learningapptask.datamodel.Repo.StudentRepo;
import com.example.learningapptask.datamodel.Student;
import com.example.learningapptask.domain.LoginDTO;
import com.example.learningapptask.domain.dtoIn.LoginDTOIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public void createNewStudent(Student student) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(student.getPassword().getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest();
            String hash = DatatypeConverter.printHexBinary(bytes);
            student.setPassword(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        student.setId(UUID.randomUUID().toString());
        student.setCourseId(UUID.randomUUID().toString());
        studentRepo.save(student);
    }

    public List<Student> allStudents() {
        Iterable<Student> studentIterable = studentRepo.findAll();
        Iterator<Student> iterator = studentIterable.iterator();
        List<Student> allStudents = new ArrayList<>();
        while(iterator.hasNext()){
            allStudents.add(iterator.next());
        }
        return allStudents;

    }
    public String deleteCourse(@PathVariable String id){
        /*Optional<Course> course = studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.delete(student.get());
        }*/
        return "Course is deleted " + id;
    }

    public LoginDTO login(LoginDTOIn loginDTOIn) {
        String hashPassword;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(loginDTOIn.getPassword().getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest();
            hashPassword = DatatypeConverter.printHexBinary(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Student std = studentRepo.findByEmailAndPassword(loginDTOIn.getEmail(), hashPassword);

        LoginDTO loginDTO = new LoginDTO(loginDTOIn.getEmail(), loginDTOIn.getPassword(), false);

        if(std != null){
            loginDTO.setIsLogin(true);
        }

        return loginDTO;
    }
    public List<Student> Students(String email, String password) {
        Iterable<Student> iterable = studentRepo.findAll();
        Iterator<Student> iterator = iterable.iterator();
        List<Student> allMatchStudents = new ArrayList<>();
        while(iterator.hasNext()) {
            allMatchStudents.add(iterator.next());
        }
        for(int i = 0; i < allMatchStudents.size(); i++){
            Student st = allMatchStudents.get(i);
            if(st.getEmail().equalsIgnoreCase(email) &&
                    st.getPassword().equals(password)){
                     st.getName();
            }
        }

        return null;
    }
}
