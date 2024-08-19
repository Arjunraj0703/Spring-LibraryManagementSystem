package com.library.rest.libraryrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.library.rest.libraryrest.*")
@EnableJpaRepositories
@EntityScan("com.library.rest.libraryrest.*")
public class LibraryRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryRestApplication.class, args);
	}

	@Bean(name = "myRest")
	RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
}
