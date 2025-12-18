package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdrepo;

    
    @Override
    public Student poststudent(Student student) {
        return stdrepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return stdrepo.findAll();
    }

    
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = stdrepo.findById(id);
        return student.orElse(null); // or throw custom exception
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = stdrepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(studentDetails.getName());
            existingStudent.setDept(studentDetails.getDept());
            existingStudent.setDob(studentDetails.getDob());
            existingStudent.setCgpa(studentDetails.getCgpa());
            return stdrepo.save(existingStudent);
        } else {
            return null; 
        }
    }

    // DELETE: Delete student by ID
    @Override
    public void deleteStudent(Long id) {
        stdrepo.deleteById(id);
    }
}