package com.example.demo.service;

import com.example.demo.entity.Student;
import java.util.*;

public interface StudentService {
    Student poststudent(Student student);           
    List<Student> getAllStudents();                 
    Optional<Student> getStudentById(Long id);                
    Student updateStudent(Long id, Student student);  
    String deleteStudent(Long id);                    
}