package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{

}