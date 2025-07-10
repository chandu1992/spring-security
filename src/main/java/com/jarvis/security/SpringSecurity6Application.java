package com.jarvis.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringSecurity6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity6Application.class, args);
	}

}
