package com.reg.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reg.backend.entity.Student;
import com.reg.backend.repository.StudentRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public Collection<Student> Students() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }

    
    }

