package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.business.IIntranetBusiness;
import com.example.entities.Administrator;
import com.example.entities.Section;
import com.example.entities.Student;
import com.example.entities.Teacher;


@SpringBootApplication
public class IntranetApplication implements CommandLineRunner {

	@Autowired
	private IIntranetBusiness intranet;

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		intranet.createAdministrator("admin", "email@intranet.fr", "password");
	}
}
