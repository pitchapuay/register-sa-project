package com.reg.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reg.backend.entity.Section;
import com.reg.backend.entity.Subject;
import com.reg.backend.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SectionController {

    @Autowired
    private final SectionRepository sectionRepository;
    @Autowired
    private final SubjectRepository subjectRepository;

    public SectionController(SectionRepository sectionRepository, SubjectRepository subjectRepository) {
        this.sectionRepository = sectionRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/section")
    public Collection<Section> Semesters() {
        return sectionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/section/{sub}")
    public Collection<Section> getSectionBySubInSec(@PathVariable("sub") Long sub) {
        return sectionRepository.findSectionBySubInSec(sub);
    }

    

}