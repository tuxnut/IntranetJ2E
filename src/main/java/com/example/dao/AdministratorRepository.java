package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	// Select one admin by Id
	@Query("SELECT a FROM Administrator a where a.id_administrator=:x")
	Administrator find(@Param("x") Long id_administrator);
}
