package com.app;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.config.AppConstants;
import com.app.entities.Role;
import com.app.repositories.RoleRepo;

@SpringBootApplication
public class AppApisApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(AppApisApplication.class, args);
		
		System.out.println("start code.......");	
		}
	
	@Bean
	public  ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(this.passwordEncoder.encode("xyz"));
        try  {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
