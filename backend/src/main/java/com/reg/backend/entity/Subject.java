package com.reg.backend.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="SUBJECT")
public class Subject {

    @Id
    @SequenceGenerator(name="subject_seq",sequenceName="subject_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subject_seq")
    @Column(name = "SUBJECT_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String sub_num;

    private @NonNull String sub_name;

    private @NonNull int credit;


	public void setName(String name) {
        this.sub_num = name;
	}

	public void setSubNum(String subnum) {
                sub_num = subnum;
	}

	public void setSubName(String string) {
                sub_name = string;
	}

	public void setCredit(int string) {
                credit = string;
	}




	
}