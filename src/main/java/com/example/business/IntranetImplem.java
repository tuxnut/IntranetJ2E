package com.example.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AdministratorRepository;
import com.example.dao.CourseRepository;
import com.example.dao.NewsRepository;
import com.example.dao.NoteRepository;
import com.example.dao.SectionRepository;
import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.entities.Administrator;
import com.example.entities.Course;
import com.example.entities.News;
import com.example.entities.Section;
import com.example.entities.Student;
import com.example.entities.Teacher;
import com.example.entities.Note;

@Service
@Transactional
public class IntranetImplem implements IIntranetBusiness {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

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
	@Autowired
	private NoteRepository noteRep;

	@Override
	public Map<String, String> addUser(HttpServletRequest request) {
		Map<String, String> m_errors = new HashMap<String, String>();

		// Retrieve inputs from the form inscription
		String r_lastname = request.getParameter("lastname");
		String r_email = request.getParameter("email");
		String r_password = request.getParameter("password");
		String r_password2 = request.getParameter("password2");
		String r_type = request.getParameter("type");
		String r_section = "";

		// validate email
		if (!VALID_EMAIL_ADDRESS_REGEX.matcher(r_email).find())
			m_errors.put("key_email", "wrong email pattern");

		// validate password
		if (!r_password.equals(r_password2))
			m_errors.put("key_password", "wrong password");

		// create entity if no errors
		if (m_errors.isEmpty()) {
			if (r_type.equals("student")) {
				r_section = request.getParameter("section");
				createStudent(r_lastname, r_email, r_password, sectionRep.findByName(r_section));
			} else if (r_type.equals("teacher")) {
				createTeacher(r_lastname, r_email, r_password);
			} else if (r_type.equals("admin")) {
				createAdministrator(r_lastname, r_email, r_password);
			}
		}
		
		return m_errors;
	}
 
	@Override
	public Map<String, String> addNote(HttpServletRequest request) {
		Map<String, String> m_errors = new HashMap<String, String>();
		
		String r_studentID = request.getParameter("student");
		String r_courseID = request.getParameter("course");
		String r_value = request.getParameter("value");
		
		Student s = studentRep.find(Long.parseLong(r_studentID));
		Course c = courseRep.find(Long.parseLong(r_courseID));
		
		if (s.getSection() != c.getSection()) {
			m_errors.put("missmatch", "Student / Course missmatch");
			return m_errors;
		}
		
		if (Integer.valueOf(r_value)< 0) {
			m_errors.put("Error", "Negative value");
			return m_errors;
		}
		createNote(Integer.valueOf(r_value), c, s);
		return m_errors;
	}
	
	@Override
	public Map<String, String> addNews(HttpServletRequest request) {
		Map<String, String> m_errors = new HashMap<String, String>();
		
		String r_title = request.getParameter("title");
		String r_content = request.getParameter("content");
		
		createNews(r_title, r_content, new Date());
		return m_errors;
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
	public Note createNote(int value, Course course, Student student) {
		Note note = noteRep.save(new Note(value, course, student));
		return note;
	}

	@Override
	public Student getStudent(Long id_student) {
		Student s = studentRep.find(id_student);
		if (s == null)
			throw new RuntimeException("Student not found");
		return s;
	}
	@Override
	public List<Note> getNoteOfStudent(Long id_student) {
		List<Note> l_note = noteRep.getNoteOfStudent(id_student);
		if (l_note == null)
			return new ArrayList<Note>();
		return l_note;
	}
	
	@Override
	public Student getStudentByMail(String mail) {
		Student s = studentRep.findByEmail(mail);
		if (s == null)
			throw new RuntimeException("Student not found");
		return s;
	}

	@Override
	public Teacher getTeacher(Long id_teacher) {
		Teacher t = teacherRep.find(id_teacher);
		if (t == null)
			throw new RuntimeException("Teacher not found");
		return t;
	}

	@Override
	public Administrator getAdmin(Long id_admin) {
		Administrator a = adminRep.find(id_admin);
		if (a == null)
			throw new RuntimeException("Administrator not found");
		return a;
	}

	@Override
	public Course getCourse(Long id_course) {
		Course c = courseRep.find(id_course);
		if (c == null)
			throw new RuntimeException("Course not found");
		return c;
	}

	@Override
	public Section getSection(Long id_section) {
		Section s = sectionRep.find(id_section);
		if (s == null)
			throw new RuntimeException("Section not found");
		return s;
	}

	@Override
	public Section getSection(String name) {
		Section s = sectionRep.findByName(name);
		if (s == null)
			throw new RuntimeException("Section not found");
		return s;
	}

	@Override
	public News getNews(Long id_news) {
		News n = newsRep.find(id_news);
		if (n == null)
			throw new RuntimeException("News not found");
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
	public Pair<String, String> loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String password = "";

		String r_email = request.getParameter("email");
		String r_password = request.getParameter("password");
		String r_type = request.getParameter("type");

		final String no_error = "";
		final String email_error = "Email not found";
		final String pwd_error = "Wrong password";

		
		Cookie c_Mail = null;
		Cookie c_Type = null;
		
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			throw new RuntimeException("Cookies not found");
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("email")) { c_Mail = cookie; }
			else if (cookie.getName().equals("userType")) { c_Type = cookie; };
		}
		switch (r_type) {
		case "admin":
			Administrator a = adminRep.findByEmail(r_email);
			if (a != null) {
				password = a.getPassword();
				if (password.equals(r_password)) {
					c_Mail.setValue(r_email);
					response.addCookie(c_Mail);
					c_Type.setValue(r_type);
					response.addCookie(c_Type);
					return Pair.of(no_error, r_type);
				}
				return Pair.of(pwd_error, r_type);
			}
			break;
		case "teacher":
			Teacher t = teacherRep.findByEmail(r_email);
			if (t != null) {
				password = t.getPassword();
				if (password.equals(r_password)) {
					c_Mail.setValue(r_email);
					response.addCookie(c_Mail);
					c_Type.setValue(r_type);
					response.addCookie(c_Type);
					return Pair.of(no_error, r_type);
				}
				return Pair.of(pwd_error, r_type);
			}
			break;
		case "student":
			Student s = studentRep.findByEmail(r_email);
			if (s != null) {
				password = s.getPassword();
				if (password.equals(r_password)) {
					c_Mail.setValue(r_email);
					response.addCookie(c_Mail);
					c_Type.setValue(r_type);
					response.addCookie(c_Type);
					return Pair.of(no_error, r_type);
				}
				return Pair.of(pwd_error, r_type);
			}
			break;
		}
		return Pair.of(email_error, r_type);
	}

	@Override
	public List<News> getAllNews() {
		List<News> l_news = new ArrayList<>();
		l_news = newsRep.getAllNews(new Date());
		return l_news;
	}

	@Override
	public List<Section> getAllSections() {
		List<Section> l_sections = new ArrayList<>();
		l_sections = sectionRep.getAllSections();
		return l_sections;
	}
	
	@Override
	public List<Student> getAllStudents() {	
		List<Student> l_notes = new ArrayList<>();
		l_notes = studentRep.getAllStudents();
		return l_notes;
	}
	
	public List<Course> getAllCourses() {
		List<Course> l_courses = new ArrayList<>();
		l_courses = courseRep.getAllCourses();
		return l_courses;
	}
}
