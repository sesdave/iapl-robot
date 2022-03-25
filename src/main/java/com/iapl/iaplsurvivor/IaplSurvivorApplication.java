package com.iapl.iaplsurvivor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IaplSurvivorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IaplSurvivorApplication.class, args);
	}

}
