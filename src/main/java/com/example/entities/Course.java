package com.example.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id_course;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_teacher_course")
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name="fk_section_course")
	private Section section;
	
	public List<Note> getL_notes() {
		return l_notes;
	}

	public void setL_notes(List<Note> l_notes) {
		this.l_notes = l_notes;
	}

	public void setId_course(Long id_course) {
		this.id_course = id_course;
	}

	@OneToMany(mappedBy="course")
	private List<Note> l_notes;

	public Course() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Course(String name, Teacher teacher, Section section) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.section = section;
	}

	public Long getId_course() {
		return id_course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
		
}
