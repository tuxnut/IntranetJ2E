package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id_note;
	private int value;
	@ManyToOne
	@JoinColumn(name="fk_course_note")
	private Course course;
	@ManyToOne
	@JoinColumn(name = "fk_student_note")
	private Student student;

	public Note() {
		super();
	}

	public Note(int value, Course course, Student student) {
		super();
		this.value = value;
		this.course = course;
		this.student = student;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
