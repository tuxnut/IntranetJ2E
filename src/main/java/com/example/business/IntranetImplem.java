package com.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AdministratorRepository;
import com.example.dao.CourseRepository;
import com.example.dao.SectionRepository;
import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.entities.Administrator;
import com.example.entities.Course;
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
	public Student getStudent(Long id_student) {
		Student s = studentRep.find(id_student);
		return s;
	}

	@Override
	public Teacher getTeacher(Long id_teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator getAdmin(Long id_admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourse(Long id_course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getSection(Long id_section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStudentToSection(Long id_student, Long id_section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStudentFromSection(Long id_student, Long id_section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentFromSection(Long id_student, Long id_lastSection, Long id_newSection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseToSection(Long id_course, Long id_section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourseFromSection(Long id_course, Long id_section) {
		// TODO Auto-generated method stub
		
	}
}
