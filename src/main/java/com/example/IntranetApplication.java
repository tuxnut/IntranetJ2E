package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.business.IIntranetBusiness;


@SpringBootApplication
public class IntranetApplication implements CommandLineRunner {
	
	private final String texte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut ipsum lorem. Curabitur posuere lorem lorem, id mattis metus convallis eget. Nunc venenatis dapibus erat, vel euismod dolor interdum nec. Mauris sit amet tincidunt ligula, vitae nullam.";

	@Autowired
	private IIntranetBusiness intranet;

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		intranet.createAdministrator("admin", "email@intranet.fr", "password");
		intranet.createSection("INGE2");
		intranet.createNews("News 0", 0 + texte, new Date());
		intranet.createNews("News 1", 1 + texte, new Date());
		intranet.createNews("News 2", 2 + texte, new Date());
		intranet.createNews("News 3", 3 + texte, new Date());
		intranet.createNews("News 4", 4 + texte, new Date());
	}
}
