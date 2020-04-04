package com.reg.backend.repository;

import com.reg.backend.entity.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RegisterRepository extends JpaRepository<Register, Long> {
}