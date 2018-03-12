package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.News;

public interface NewsRepository extends JpaRepository<News, Long> {
	// Select one News by Id
	@Query("SELECT n FROM News n where n.id_news=:x")
	News find(@Param("x") Long id_id_news);
}
