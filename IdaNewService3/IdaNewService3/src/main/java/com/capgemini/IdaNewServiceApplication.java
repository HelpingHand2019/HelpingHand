package com.capgemini;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling

@SpringBootApplication

@ComponentScan(basePackages = "com.capgemini.*")

public class IdaNewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdaNewServiceApplication.class, args);

	}
}
