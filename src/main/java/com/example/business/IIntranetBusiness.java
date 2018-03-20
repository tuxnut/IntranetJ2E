package com.example.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.util.Pair;

import com.example.entities.Administrator;
import com.example.entities.Course;
import com.example.entities.News;
import com.example.entities.Section;
import com.example.entities.Student;
import com.example.entities.Teacher;
import com.example.entities.Note;

public interface IIntranetBusiness {
	// Login
	public Pair<String, String> loginProcess(HttpServletRequest request, HttpServletResponse response);
	
	// Creation
	public Map<String, String> addUser(HttpServletRequest request);
	public Map<String, String> addNote(HttpServletRequest request);
	public Map<String, String> addNews(HttpServletRequest request);
	public Student createStudent(String name, String email, String password, Section section);
	public Teacher createTeacher(String name, String email, String password);
	public Administrator createAdministrator(String name, String email, String password);
	public Section createSection(String name);
	public Course createCourse(String name, Teacher teacher, Section section);
	public News createNews(String title, String text, Date publicationDate);
	public Note createNote(int value, Course course, Student student);

	// Reading
	public Student getStudent(Long id_student);
	public Student getStudentByMail(String mail);
	public Teacher getTeacher(Long id_teacher);
	public Teacher getTeacherByMail(String mail);
	public Administrator getAdmin(Long id_admin);
	public Course getCourse(Long id_course);
	public Section getSection(Long id_section);
	public Section getSection(String name);
	public List<Note> getNoteOfStudent(Long id_student);
	public List<Section> getAllSections();
	public News getNews(Long id_news);
	public List<News> getAllNews();
	public List<News> getAllNews2();
	public List<Student> getAllStudents();
	
	// modifying students inside sections
	public void addStudentToSection(Student student, Section section);
	
	// modifying courses inside sections
	public void addCourseToSection(Course course, Section section);
	public void removeCourseFromSection(Course course, Section section);
	
	//public void changeTeacherOfCourse(Long id_newTeacher, Long id_Course);
}
