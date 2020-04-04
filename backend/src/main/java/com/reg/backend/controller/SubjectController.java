package com.reg.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reg.backend.entity.Subject;
import com.reg.backend.repository.SubjectRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SubjectController {

    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/subject")
    public Collection<Subject> Subjects() {
        return subjectRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/subject/{id}")
    public Optional<Subject> Students(@PathVariable Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject;
    }

}