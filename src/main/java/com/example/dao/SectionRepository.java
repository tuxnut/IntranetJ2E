package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
