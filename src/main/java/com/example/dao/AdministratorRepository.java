package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
