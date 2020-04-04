package com.reg.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import com.reg.backend.entity.*;
import com.reg.backend.repository.*;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(StudentRepository studentRepository, SectionRepository sectionRepository, SubjectRepository subjectRepository, SemesterRepository semesterRepository) {
		return args -> {
			Stream.of("1/62", "2/62", "3/62","1/63", "2/63", "3/63").forEach(name -> {
				Semester semester = new Semester(); // สร้าง Object Semester
				semester.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Semester
				semesterRepository.save(semester); // บันทึก Objcet ชื่อ Semester
			});

			//subject
			Subject sj1 = new Subject();
			sj1.setSubNum("523331");
			sj1.setSubName("SYSTEM ANALYSIS AND DESIGN");
			sj1.setCredit(4);
			subjectRepository.save(sj1);

			Subject sj2 = new Subject();
			sj2.setSubNum("523371");
			sj2.setSubName("MICROPROCESSORS");
			sj2.setCredit(4);
			subjectRepository.save(sj2);

			Subject sj3 = new Subject();
			sj3.setSubNum("523301");
			sj3.setSubName("COMPUTER STATISTICS");
			sj3.setCredit(2);
			subjectRepository.save(sj3);

			Subject sj4 = new Subject();
			sj4.setSubNum("523351");
			sj4.setSubName("FORMAL METHODS AND COMPUTABILITY");
			sj4.setCredit(4);
			subjectRepository.save(sj4);

			Subject sj5 = new Subject();
			sj5.setSubNum("202207");
			sj5.setSubName("MAN, ECONOMY AND DEVELOPMENT");
			sj5.setCredit(3);
			subjectRepository.save(sj5);

			Subject sj6 = new Subject();
			sj6.setSubNum("523232");
			sj6.setSubName("OBJECT-ORIENTED TECHNOLOGY");
			sj6.setCredit(4);
			subjectRepository.save(sj6);

			//student
			Student st1 = new Student();
			st1.setStudentName("กิตติชัย จิตเจริญ");
			st1.setStudentNum("B6001520");
			studentRepository.save(st1);

			Student st2 = new Student();
			st2.setStudentName("กิตติธร แสงจีน");
			st2.setStudentNum("B6012496");
			studentRepository.save(st2);

			Student st3 = new Student();
			st3.setStudentName("พิชชาพร แป้นศรี");
			st3.setStudentNum("B6001803");
			studentRepository.save(st3);

			Student st4 = new Student();
			st4.setStudentName("ณัฐพงษ์ พูนทรัพย์");
			st4.setStudentNum("B6015305");
			studentRepository.save(st4);

			Student st5 = new Student();
			st5.setStudentName("คงเดช เที่ยงทางธรรม");
			st5.setStudentNum("B6001537");
			studentRepository.save(st5);

			//section

			//sa
			Section sec1 = new Section();
			sec1.setName("1");
			sec1.setSubInSec(sj1);
			sectionRepository.save(sec1);
			
			Section sec2 = new Section();
			sec2.setName("2");
			sec2.setSubInSec(sj1);
			sectionRepository.save(sec2);

			Section sec3 = new Section();
			sec3.setName("3");
			sec3.setSubInSec(sj1);
			sectionRepository.save(sec3);

			//micro
			Section sec1_2 = new Section();
			sec1_2.setName("1");
			sec1_2.setSubInSec(sj2);
			sectionRepository.save(sec1_2);

			Section sec2_2 = new Section();
			sec2_2.setName("2");
			sec2_2.setSubInSec(sj2);
			sectionRepository.save(sec2_2);

			Section sec3_2 = new Section();
			sec3_2.setName("3");
			sec3_2.setSubInSec(sj2);
			sectionRepository.save(sec3_2);

			Section sec4_2 = new Section();
			sec4_2.setName("4");
			sec4_2.setSubInSec(sj2);
			sectionRepository.save(sec4_2);

			//com stat
			Section sec1_3 = new Section();
			sec1_3.setName("1");
			sec1_3.setSubInSec(sj3);
			sectionRepository.save(sec1_3);

			Section sec2_3 = new Section();
			sec2_3.setName("2");
			sec2_3.setSubInSec(sj3);
			sectionRepository.save(sec2_3); 

			//formal
			Section sec1_4 = new Section();
			sec1_4.setName("1");
			sec1_4.setSubInSec(sj4);
			sectionRepository.save(sec1_4);

			Section sec2_4 = new Section();
			sec2_4.setName("2");
			sec2_4.setSubInSec(sj4);
			sectionRepository.save(sec2_4); 

			//man eco
			Section sec1_5 = new Section();
			sec1_5.setName("1");
			sec1_5.setSubInSec(sj5);
			sectionRepository.save(sec1_5); 

			//java
			Section sec1_6 = new Section();
			sec1_6.setName("1");
			sec1_6.setSubInSec(sj6);
			sectionRepository.save(sec1_6); 
			

			studentRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Student บน Terminal
			sectionRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Section บน Terminal
			semesterRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Semester บน Terminal
			subjectRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Semester บน Terminal
		};
	}

}
