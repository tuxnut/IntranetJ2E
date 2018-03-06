package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
