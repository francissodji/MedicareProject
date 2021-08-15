package com.healthcare.Medicare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.healthcare.model")
@EnableJpaRepositories("com.healthcare.dao")
public class MedicareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicareApplication.class, args);
	}

}
