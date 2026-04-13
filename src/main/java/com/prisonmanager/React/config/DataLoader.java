package com.prisonmanager.React.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prisonmanager.React.Entity.User;
import com.prisonmanager.React.Repo.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner run(UserRepository repo, PasswordEncoder encoder) {
        return args -> {

            // check if admin already exists
            if (repo.findByName("admin").isEmpty()) {

                User user = new User();
                user.setName("admin");
                user.setPassword(encoder.encode("1234")); // 🔐 hashed
                repo.save(user);

                System.out.println("Admin user created!");
            }
        };
    }
}