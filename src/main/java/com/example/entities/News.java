package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {

	@Id @GeneratedValue
	private Long id_news;
	
	private String title;
	private String text;
	private Date publicationDate;
	
	public News(String title, String text, Date publicationDate) {
		super();
		this.title = title;
		this.text = text;
		this.publicationDate = publicationDate;
	}

	public News() {
		super();
	}

	public Long getId_news() {
		return id_news;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

}
