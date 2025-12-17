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
        return stdser.poststudent(st);
    }

}