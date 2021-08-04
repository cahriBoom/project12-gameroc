package com.project.gamerback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GamerbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerbackApplication.class, args);
	}

}
