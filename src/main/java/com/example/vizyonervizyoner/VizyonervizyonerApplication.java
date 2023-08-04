package com.example.vizyonervizyoner;

import com.example.vizyonervizyoner.User.Role;
import com.example.vizyonervizyoner.User.RoleRepo;
import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class VizyonervizyonerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VizyonervizyonerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder encoder){
		return args -> {
			if(roleRepo.findByAuthority("ROLE_ADMIN").isPresent()) return;
			Role adminRole = roleRepo.save(new Role("ROLE_ADMIN"));
			Role userRole =  roleRepo.save(new Role("ROLE_USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			Set<Role> roles2 = new HashSet<>();
			roles2.add(userRole);

			Users admin = new Users("admin","admin","admin", encoder.encode("admin"),roles);
			userRepo.save(admin);
			Users user = new Users("user","user","user", encoder.encode("user"),roles2);
			userRepo.save(user);
		};
	}
}
