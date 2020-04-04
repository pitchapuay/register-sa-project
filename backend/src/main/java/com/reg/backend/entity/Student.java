package com.reg.backend.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="STUDENT")
public class Student {

    @Id
    @SequenceGenerator(name="student_seq",sequenceName="student_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq")
    @Column(name = "STUDENT_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String student_name;

    private @NonNull String student_num;

	public void setStudentName(String string) {
      this.student_name = string;
   }

   public void setStudentNum(String string) {
      this.student_num = string;
}


}