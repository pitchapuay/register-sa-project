package com.reg.backend.repository;

import com.reg.backend.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface StudentRepository extends JpaRepository<Student, Long> {
	Student findById(long id);
}