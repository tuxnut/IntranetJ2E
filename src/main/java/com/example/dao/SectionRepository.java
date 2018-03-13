package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	// Select one section by Id
	@Query("SELECT s FROM Section s where s.id_section=:x")
	Section find(@Param("x") Long id_section);
	
	// Select one section by name
	@Query("SELECT s FROM Section s where s.name=:x")
	Section findByName(@Param("x") String name);
	
	// Select every section
	@Query("SELECT s FROM Section s")
	List<Section> getAllSections();
}
