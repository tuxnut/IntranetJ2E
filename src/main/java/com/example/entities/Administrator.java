package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id_administrator;
	private String name;
	private String email;
	private String password;

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(String name, String email, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId_administrator() {
		return id_administrator;
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
