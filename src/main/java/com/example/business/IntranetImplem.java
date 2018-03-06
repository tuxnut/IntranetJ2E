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
	public Student getStudent(Long id_Student) {
		Student student = studentRep.findOne(id_Student);
		if (student == null) throw new RuntimeException("Student not found");
		return student;
	}

	@Override
	public Teacher getTeacher(Long id_Teacher) {
		Teacher teacher = teacherRep.findOne(id_Teacher);
		if (teacher == null) throw new RuntimeException("Teacher not found");
		return teacher;
	}

	@Override
	public Administrator getAdmin(Long id_Admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourse(Long id_Course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getSection(Long id_Section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStudentToSection(Long id_Student, Long id_Section) {
//		Student student = studentRep.findOne(id_Student);
		
	}

	@Override
	public void removeStudentFromSection(Long id_Student, Long id_Section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentFromSection(Long id_Student, Long id_lastSection, Long id_newSection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseToSection(Long id_Course, Long id_Section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourseFromSection(Long id_Course, Long id_Section) {
		// TODO Auto-generated method stub
		
	}
}
