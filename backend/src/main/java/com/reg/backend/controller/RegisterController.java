package com.reg.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import com.reg.backend.entity.*;
import com.reg.backend.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RegisterController {
    @Autowired
    private final RegisterRepository registerRepository;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private  SemesterRepository semesterRepository;
    @Autowired
    private  SectionRepository sectionRepository;
    @Autowired
    private  SubjectRepository subjectRepository;

    

    RegisterController(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
    }

    @GetMapping("/register")
    public Collection<Register> Registers() {
        return registerRepository.findAll().stream().collect(Collectors.toList());
    }
  


    //save register
    @PostMapping("/register/{student_id}/{semester_id}/{section_id}/{sub_num}/{credit}")
    public Register newRegister(Register newRegister,
    @PathVariable long student_id,
    @PathVariable long semester_id,
    @PathVariable long section_id,
    @PathVariable String sub_num,
    @PathVariable int credit)
    {

    Student registerBy = studentRepository.findById(student_id);
    Semester inSemester = semesterRepository.findById(semester_id);
    Section chooseSec = sectionRepository.findById(section_id);
    LocalDateTime registerDate = LocalDateTime.now();
    
    newRegister.setRegisterBy(registerBy); //student
    newRegister.setSemester(inSemester); //semester
    newRegister.setChooseSec(chooseSec); //section
    newRegister.setRegisterDate(registerDate); //set date
    newRegister.setSubNum((String)sub_num); //set sub_num
    newRegister.setCredit(credit); //set credit
    
    return registerRepository.save(newRegister); //บันทึก Objcet ชื่อ Register
    }
    
}