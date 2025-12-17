//
package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository stdrepo;
    @Override
    public Student poststudent(Student st){
        return stdrepo.save(st);
    }
}