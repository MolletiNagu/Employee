package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.employee")
public class PrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjApplication.class, args);
	}

}
