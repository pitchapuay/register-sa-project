package com.reg.backend.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="SEMESTER")
public class Semester {

    @Id
    @SequenceGenerator(name="semester_seq",sequenceName="semester_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="semester_seq")
    @Column(name = "SEMESTER_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String sem;
/*
    //1-* with register
    @OneToMany(fetch = FetchType.EAGER ,mappedBy="register")
    @JsonManagedReference
    private Collection<Register> register;
    
 /*
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Register.class)
    @JoinColumn(name = "REGISTER_ID", insertable = true)
    private Register register;
*/
    


	public void setName(String name) {
        this.sem = name;
	}



}