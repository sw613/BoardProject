package com.example.team5_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Team5ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team5ProjectApplication.class, args);
	}

}
