package com.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.config.AppConstants;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.payloads.UserDto;
import com.app.services.UserService;

import lombok.Getter;
import lombok.Setter;

import com.app.repositories.*;
import com.app.exceptions.*;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo; 

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	
	//for create new user
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user =this.dtoToUser(userDto);
		User savedUser =this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	//for update user
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 =this.userToDto(updateUser);
		
		return userDto1;
	}

	//data return for particular Id
	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	//for all user
	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	//for delete user
	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
         this.userRepo.delete(user);
	}
	
	//from Dto to user entity
	private User dtoToUser(UserDto userDto) {
		/*User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(user.getEmail());
		user.setAbout(userDto.getEmail());
		user.setPassword(userDto.getPassword());*/
		
		//for conversion  by using madelMapper
		User user = this.modelMapper.map(userDto, User.class);
		return user;
		
	}
	
	//from  to user entity to Dto
	public UserDto userToDto(User user) {
		/*UserDto userDto =new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());*/
		
		//for conversion using modelMapper
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
		
		@Override
		public UserDto registerNewUser(UserDto userDto) {

			User user = this.modelMapper.map(userDto, User.class);

			//encoded the password
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));

			//roles 
			Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
			user.getRoles().add(role);

			User newUser = this.userRepo.save(user);

			return this.modelMapper.map(newUser, UserDto.class);
		}

	}
