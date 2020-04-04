package com.reg.backend.repository;

import java.util.Collection;

import com.reg.backend.entity.Section;
import com.reg.backend.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SubjectRepository extends JpaRepository<Subject, Long> {
	Subject findById(long id);

	/*@Query( value = "SELECT * FROM SECTION as sc INNER JOIN  SUBJECT   as  sj on sc.SUBJECT_ID  = sj.SUBJECT_ID where sj.SUBJECT_ID  = :subInSec",
            nativeQuery = true)
    Collection<Section> findSectionBySubInSec(@Param("subInSec") String subInSec);*/
}