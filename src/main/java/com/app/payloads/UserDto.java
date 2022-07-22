package com.app.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	//@NotNull
	//NotEmpty is for both blank and null
	@NotEmpty
	@Size(min =4, message="Username must be min of 4 characters")
	private String name;
	
	@Email(message="Your email address is not valid !!")
	private String email;
	
	//@NotNull
	@NotEmpty
	@Size(min =3, max=10, message="Password must be min of 3 chars and max must be 10 chars !!")
	private String password;
	
	//@NotNull
	@NotEmpty
	private String about;
	
	private Set<Role> roles = new HashSet<>();

}
