package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// Select all students from one section
	//@Query("SELECT * FROM Student WHERE Student.fk_section_student=:x")
	//public List<Student> getStudentsFromSection(@Param("x") Long id_Section);

}