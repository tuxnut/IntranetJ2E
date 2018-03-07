package com.example.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id_section;
	private String name;
	
	@OneToMany(mappedBy="section")
	private List<Course> l_courses;
	
	@OneToMany(mappedBy="section")
	private List<Student> l_students;
	
	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(String name) {
		super();
		this.name = name;
	}

	public Long getId_section() {
		return id_section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getL_courses() {
		return l_courses;
	}

	public void setL_courses(List<Course> l_courses) {
		this.l_courses = l_courses;
	}

	public List<Student> getL_students() {
		return l_students;
	}

	public void setL_students(List<Student> l_students) {
		this.l_students = l_students;
	}

	
}
