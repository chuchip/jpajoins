package com.profesorp.jpajoins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaJoinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaJoinsApplication.class, args);
	}
	
	
}
