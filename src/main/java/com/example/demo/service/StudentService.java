// StudentService.java
package com.example.demo.service;

import com.example.demo.entity.Student;
import java.util.List;

public interface StudentService {

    // CREATE
    Student poststudent(Student st);

    // READ: Get all students
    List<Student> getAllStudents();

    // READ: Get student by ID
    Student getStudentById(Long id);

    // UPDATE: Update student by ID
    Student updateStudent(Long id, Student student);

    // DELETE: Delete student by ID
    void deleteStudent(Long id);
}