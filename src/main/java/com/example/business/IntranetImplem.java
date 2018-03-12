package com.example.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AdministratorRepository;
import com.example.dao.CourseRepository;
import com.example.dao.NewsRepository;
import com.example.dao.SectionRepository;
import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.entities.Administrator;
import com.example.entities.Course;
import com.example.entities.News;
import com.example.entities.Section;
import com.example.entities.Student;
import com.example.entities.Teacher;

@Service
@Transactional
public class IntranetImplem implements IIntranetBusiness {
	
	@Autowired
	private StudentRepository studentRep;
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private AdministratorRepository adminRep;
	@Autowired
	private SectionRepository sectionRep;
	@Autowired
	private CourseRepository courseRep;
	@Autowired
	private NewsRepository newsRep;
	
	@Override
	public String addUser(HttpServletRequest request) {
		Map<String, String> l_errors = new HashMap<String, String>();
		
		// Retrieve inputs from form
		String r_lastname = request.getParameter("lastname");
		String r_firstname = request.getParameter("firstname");
		String r_email = request.getParameter("email");
		String r_password = request.getParameter("password");
		String r_password2 = request.getParameter("password2");
		String r_type = request.getParameter("type");
		String r_section = "";
		if (r_type.equals("student")) r_section = request.getParameter("section");
		
		
		
		return "";
	}

	@Override
	public Student createStudent(String name, String email, String password, Section section) {
		Student student = new Student(name, email, password);
		student.setSection(section);
		studentRep.save(student);
		return student;
	}

	@Override
	public Teacher createTeacher(String name, String email, String password) {
		Teacher teacher = teacherRep.save(new Teacher(name, email, password));
		return teacher;
	}

	@Override
	public Administrator createAdministrator(String name, String email, String password) {
		Administrator admin = adminRep.save(new Administrator(name, email, password));
		return admin;
	}

	@Override
	public Section createSection(String name) {
		Section section = sectionRep.save(new Section(name));
		return section;
	}

	@Override
	public Course createCourse(String name, Teacher teacher, Section section) {
		Course course = courseRep.save(new Course(name, teacher, section));
		return course;
	}
	
	@Override
	public News createNews(String title, String text, Date publicationDate) {
		News news = newsRep.save(new News(title, text, publicationDate));
		return news;
	}

	@Override
	public Student getStudent(Long id_student) {
		Student s = studentRep.find(id_student);
		if (s == null) throw new RuntimeException("Student not found");
		return s;
	}

	@Override
	public Teacher getTeacher(Long id_teacher) {
		Teacher t = teacherRep.find(id_teacher);
		if (t == null) throw new RuntimeException("Teacher not found");
		return t;
	}

	@Override
	public Administrator getAdmin(Long id_admin) {
		Administrator a = adminRep.find(id_admin);
		if (a == null) throw new RuntimeException("Administrator not found");
		return a;
	}

	@Override
	public Course getCourse(Long id_course) {
		Course c = courseRep.find(id_course);
		if (c == null) throw new RuntimeException("Course not found");
		return c;
	}

	@Override
	public Section getSection(Long id_section) {
		Section s = sectionRep.find(id_section);
		if (s == null) throw new RuntimeException("Section not found");
		return s;
	}
	
	@Override
	public News getNews(Long id_news) {
		News n = newsRep.find(id_news);
		if (n == null) throw new RuntimeException("News not found");
		return n;
	}

	@Override
	public void addStudentToSection(Student student, Section section) {
		student.setSection(section);
		section.getL_students().add(student);
		studentRep.save(student);
	}

	@Override
	public void addCourseToSection(Course course, Section section) {
		course.setSection(section);
		section.getL_courses().add(course);
		courseRep.save(course);
	}

	@Override
	public void removeCourseFromSection(Course course, Section section) {
		section.getL_courses().remove(course);
		course.setSection(null);
		courseRep.save(course);
	}

	@Override
	public String loginProcess(HttpServletRequest request) {		
		String password = "";
		String r_email = request.getParameter("email");
		String r_password = request.getParameter("password");
		String error = "Wrong password";
		
		Teacher t;
		Student s;
		Administrator a;
		
		a = adminRep.findByEmail(r_email);
		if (a != null) {
			password = a.getPassword();
			return (password.equals(r_password)) ? "admin" : error;
		}
		
		t = teacherRep.findByEmail(r_email);
		if (t != null) {
			password = t.getPassword();
			return (password.equals(r_password)) ? "teacher" : error;
		}
		
		s = studentRep.findByEmail(r_email);
		if (s != null) {
			password = s.getPassword();
			return (password.equals(r_password)) ? "student" : error;
		}
			
		return "Email not found"; // User not registered
	}
	
	@Override
	public String logoutProcess(HttpServletRequest request) {
		return request.getParameter("answer");
	}
}
