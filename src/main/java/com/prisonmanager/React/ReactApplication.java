package com.prisonmanager.React;

import com.prisonmanager.React.Repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.prisonmanager.React.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactApplication.class, args);
	}


}
