package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;   
import com.example.demo.entity.Student;        
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")   
public class StudentController {

    @Autowired
    StudentService stdser;

    
    @PostMapping('/addStudent')
    public Student addStudent(@RequestBody Student st) {
        return studentService.poststudent(student);
    }

    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        // You’ll need a corresponding method in StudentService
        return null; // placeholder
    }

    
    @GetMapping
    public Iterable<Student> getAllStudents() {
        // You’ll need a corresponding method in StudentService
        return null; // placeholder
    }
}