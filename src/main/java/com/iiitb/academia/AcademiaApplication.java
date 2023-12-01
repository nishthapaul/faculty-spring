package com.iiitb.academia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class AcademiaApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaApplication.class, args);
	}

}
