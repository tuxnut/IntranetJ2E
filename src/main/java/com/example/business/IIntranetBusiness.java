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
	public Student getStudent(Long id_student);
	public Teacher getTeacher(Long id_teacher);
	public Administrator getAdmin(Long id_admin);
	public Course getCourse(Long id_course);
	public Section getSection(Long id_section);
//	public Teacher getTeacher(Long id_Teacher);
	
	// modifying students inside sections
	public void addStudentToSection(Long id_student, Long id_section);
	public void removeStudentFromSection(Long id_student, Long id_section);
	public void changeStudentFromSection(Long id_student, Long id_lastSection, Long id_newSection);
	
	// modifying courses inside sections
	public void addCourseToSection(Long id_course, Long id_section);
	public void removeCourseFromSection(Long id_course, Long id_section);
	
	//public void changeTeacherOfCourse(Long id_newTeacher, Long id_Course);
}
