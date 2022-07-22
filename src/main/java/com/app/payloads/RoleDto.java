package com.app.payloads;

import java.util.Set;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class RoleDto {
	
	private int id;
	private String name;
}