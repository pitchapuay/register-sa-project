package com.reg.backend.repository;

import com.reg.backend.entity.Semester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SemesterRepository extends JpaRepository<Semester, Long> {
    Semester findById(long id);
}