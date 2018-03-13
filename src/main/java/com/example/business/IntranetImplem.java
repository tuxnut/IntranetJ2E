package com.example.business;

import java.time.LocalDateTime;
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

	@Override
	public Map<String, String> addUser(HttpServletRequest request) {
		Map<String, String> m_errors = new HashMap<String, String>();

		// Retrieve inputs from the form inscription
		String r_lastname = request.getParameter("lastname");
		String r_firstname = request.getParameter("firstname");
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

		System.out.println(m_errors.get("key_email"));
		System.out.println(m_errors.get("key_password"));

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
	public Student getStudent(Long id_student) {
		Student s = studentRep.find(id_student);
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

		
		Cookie cookieMail = new Cookie("email", "");
		cookieMail.setMaxAge(60 * 60 * 24);
		cookieMail.setPath("/");
		cookieMail.setSecure(false);
		Cookie cookieType = new Cookie("userType", "");
		cookieType.setMaxAge(60 * 60 * 24);
		cookieType.setPath("/");
		cookieType.setSecure(false);
		switch (r_type) {
		case "admin":
			Administrator a = adminRep.findByEmail(r_email);
			if (a != null) {
				password = a.getPassword();
				System.out.println("r_email ===> " + r_email);
				System.out.println("password ==> " + password);
				if (password.equals(r_password)) {
					cookieMail.setValue(r_email);
					response.addCookie(cookieMail);
					cookieType.setValue(r_type);
					response.addCookie(cookieType);
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
					cookieMail.setValue(r_email);
					cookieType.setValue(r_type);
					response.addCookie(cookieMail);
					response.addCookie(cookieType);
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
					cookieMail.setValue(r_email);
					cookieType.setValue(r_type);
					response.addCookie(cookieMail);
					response.addCookie(cookieType);
					return Pair.of(no_error, r_type);
				}
				return Pair.of(pwd_error, r_type);
			}
			break;
		}
		return Pair.of(email_error, r_type);
	}

	@Override
	public List<News> getAllNews(Date date) {
		return null;
	}
}
