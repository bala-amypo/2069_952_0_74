package com.example.demo.service;

import com.example.demo.entity.Student;
import java.util.List;

public interface StudentService {
    Student poststudent(Student student);          // CREATE
    List<Student> getAllStudents();                // READ all
    Student getStudentById(Long id);               // READ one
    Student updateStudent(Long id, Student student); // UPDATE
    void deleteStudent(Long id);                   // DELETE
}