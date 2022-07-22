package com.app.services;

import java.util.List;

import com.app.entities.Post;
import com.app.payloads.PostDto;
import com.app.payloads.PostResponse;


public interface PostService {
	
	//create post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update post
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete Post
	void deletePost(Integer postId);
	
	//get all posts
	//List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

	
	//get a single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);

	

}
