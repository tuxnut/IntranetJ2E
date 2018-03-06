package com.example.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	@Id @GeneratedValue
	private Long id_Teacher;
	@OneToMany(mappedBy="teacher")
	private List<Course> l_courses;

	public Teacher() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Teacher(String name, String email, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId_Teacher() {
		return id_Teacher;
	}
	
	public List<Course> getL_courses() {
		return l_courses;
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

}
