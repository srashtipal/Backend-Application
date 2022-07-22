package com.app.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.Category;
import com.app.entities.Comment;
import com.app.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String title;
	
	private String content;
	
	//private String imageName="default.png";
	private String imageName;
	
	private Date addedDate;
	
	//categoryDto not create recursion
    private CategoryDto category;
    
    //userDto not create recursion
    private UserDto user;
	
    private Set<Comment> comments = new HashSet<>();

}
