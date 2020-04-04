package com.reg.backend.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="SECTION") 
public class Section {

    @Id
    @SequenceGenerator(name="section_seq",sequenceName="section_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="section_seq")
    @Column(name = "SECTION_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String sec;

    // *-1 with subject
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Subject.class)
    @JoinColumn(name = "SUBJECT_ID", insertable = true)
    private Subject subInSec;

    public void setName(String name) {
        this.sec = name;
	}

	public void setSubInSec(Subject sec) {
        this.subInSec = sec;
	}

	

}