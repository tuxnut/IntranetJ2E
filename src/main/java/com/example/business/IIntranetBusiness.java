package com.example.business;

import com.example.entities.Administrator;
import com.example.entities.Course;
import com.example.entities.Section;
import com.example.entities.Student;
import com.example.entities.Teacher;


public interface IIntranetBusiness {
	// Creation
	public Student createStudent(String name, String email, String password, Section section);
	public Teacher createTeacher(String name, String email, String password);
	public Administrator createAdministrator(String name, String email, String password);
	public Section createSection(String name);
	public Course createCourse(String name, Teacher teacher, Section section);
	// public News createNews(/* */);

	// Reading
	public Student getStudent(Long id_Student);
	public Teacher getTeacher(Long id_Teacher);
	public Administrator getAdmin(Long id_Admin);
	public Course getCourse(Long id_Course);
	public Section getSection(Long id_Section);
//	public Teacher getTeacher(Long id_Teacher);
	
	// modifying students inside sections
	public void addStudentToSection(Long id_Student, Long id_Section);
	public void removeStudentFromSection(Long id_Student, Long id_Section);
	public void changeStudentFromSection(Long id_Student, Long id_lastSection, Long id_newSection);
	
	// modifying courses inside sections
	public void addCourseToSection(Long id_Course, Long id_Section);
	public void removeCourseFromSection(Long id_Course, Long id_Section);
	
	//public void changeTeacherOfCourse(Long id_newTeacher, Long id_Course);
}
