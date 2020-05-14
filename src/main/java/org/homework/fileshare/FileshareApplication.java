package org.homework.fileshare;

import org.homework.fileshare.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FileshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileshareApplication.class, args);
	}
}
