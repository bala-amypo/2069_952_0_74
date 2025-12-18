package com.example.demo.service;

import com.example.demo.entity.Student;
import java.util.List;

public interface StudentService {
    Student poststudent(Student student);          
    List<Student> getAllStudents();                
    Optional<Student> getStudentById(Long id);               
    Student updateStudent(Long id, Student student); 
    void deleteStudent(Long id);                   
}