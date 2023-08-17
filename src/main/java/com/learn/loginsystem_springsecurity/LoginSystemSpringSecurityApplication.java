package com.learn.loginsystem_springsecurity;

import com.learn.loginsystem_springsecurity.models.ApplicationUser;
import com.learn.loginsystem_springsecurity.repository.RoleRepository;
import com.learn.loginsystem_springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.learn.loginsystem_springsecurity.models.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LoginSystemSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSystemSpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {

            if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

            Role adminRole = roleRepository.save(new Role(1,"ADMIN"));
            roleRepository.save(new Role(2,"USER"));
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            ApplicationUser admin = new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
            userRepository.save(admin);
        };
    }
}
