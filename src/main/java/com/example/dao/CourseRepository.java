package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	// Select one course by Id
	@Query("SELECT c FROM Course c where c.id_course=:x")
	Course find(@Param("x") Long id_course);
		
	@Query("SELECT c FROM Course c")
	List<Course> getAllCourses();
//	// Select all courses from one Section
//	@Query("SELECT c FROM Course c WHERE Course.fk_section_course=:x")
//	public List<Course> getCoursesFromSection(@Param("x") Long id_Section);
//	
//	// Select all courses from one Teacher
//	@Query("SELECT c FROM Course c WHERE Course.fk_teacher_course=:x")
//	public List<Course> getCoursesFromTeacher(@Param("x") Long id_Teacher);
//	
//	// Select all courses from one Student
//	@Query("SELECT c FROM Course c WHERE Course.fk_section_course = (SELECT s.fk_section_student FROM Student s WHERE Student.id_student:x)")
//	public List<Course> getCoursesFromStudent(@Param("x") Long id_Student);
}
