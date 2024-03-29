package com.binovizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EnversApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnversApplication.class, args);
	}

}
