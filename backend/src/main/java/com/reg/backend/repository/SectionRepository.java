package com.reg.backend.repository;

import java.util.Collection;

import com.reg.backend.entity.Section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SectionRepository extends JpaRepository<Section, Long> {
    Section findById(long id);
    

    @Query( value = "SELECT * FROM SECTION s where s.SUBJECT_ID  = :sub",
            nativeQuery = true)
    Collection<Section> findSectionBySubInSec(@Param("sub") Long sub);
    
}