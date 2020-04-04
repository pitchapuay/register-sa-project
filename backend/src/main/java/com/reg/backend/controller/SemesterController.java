package com.reg.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.reg.backend.entity.Semester;
import com.reg.backend.repository.SemesterRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SemesterController {

    @Autowired
    private final SemesterRepository semesterRepository;

    public SemesterController(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @GetMapping("/semester")
    public Collection<Semester> Semesters() {
        return semesterRepository.findAll().stream().collect(Collectors.toList());
    }

}