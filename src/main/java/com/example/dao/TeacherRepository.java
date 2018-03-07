package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	// Select one course by Id
	@Query("SELECT t FROM Teacher t where t.id_teacher=:x")
	Teacher find(@Param("x") Long id_teacher);
}
