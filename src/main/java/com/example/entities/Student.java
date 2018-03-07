package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long id_student;
	private String name;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name="fk_section_student")
	private Section section;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId_student() {
		return id_student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
