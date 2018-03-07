package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	// Select one section by Id
	@Query("SELECT s FROM Section s where s.id_section=:x")
	Section find(@Param("x") Long id_section);
}
