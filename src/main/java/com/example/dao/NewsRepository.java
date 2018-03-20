package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.News;

public interface NewsRepository extends JpaRepository<News, Long> {
	// Select one News by Id
	@Query("SELECT n FROM News n where n.id_news=:x")
	News find(@Param("x") Long id_news);
	
	// Select all news
//	@Query("Select n from News n where n.publicationDate<=:x")
	@Query("Select n from News n WHERE publication_date>=:x ORDER BY publication_date DESC")
	List<News> getAllNews(@Param("x") Date date);
}
