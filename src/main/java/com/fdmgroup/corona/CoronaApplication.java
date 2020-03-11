package com.fdmgroup.corona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fdmgroup.repos")
@EntityScan(basePackages = "com.fdmgroup.entities")


public class CoronaApplication {


	public static void main(String[] args) {
		SpringApplication.run(CoronaApplication.class, args);
	}

}
