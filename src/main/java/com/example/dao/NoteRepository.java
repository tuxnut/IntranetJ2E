package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{

	@Query("SELECT n FROM Note n WHERE fk_student_note=:x")
	List<Note> getNoteOfStudent(@Param("x") Long id_student);	
}