package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Department cannot be null")
    @Size(min = 2, max = 30, message = "Department must be between 2 and 30 characters")
    private String dept;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @Min(value = 0, message = "CGPA must be at least 0")
    @Max(value = 10, message = "CGPA must not exceed 10")
    private float cgpa;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public float getCgpa() {
        return cgpa;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Student() {
    }

    public Student(Long id, String name, String dept, LocalDate dob, float cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.dob = dob;
        this.cgpa = cgpa;
    }
}