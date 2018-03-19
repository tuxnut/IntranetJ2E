package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	// Select one course by Id
	@Query("SELECT c FROM Course c WHERE c.id_course=:x")
	Course find(@Param("x") Long id_course);
		
//	@Query("SELECT c FROM Course c WHERE c.fk_teacher_course=:x")
//	List<Course> getCoursesOfTeacher(@Param("x") Long id_teacher);
}
