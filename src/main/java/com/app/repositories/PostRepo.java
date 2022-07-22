package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Category;
import com.app.entities.Post;
import com.app.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
	//custom finder method for user
	List<Post> findByUser(User user);
	
	//custom finder method for category
	List<Post> findByCategory(Category category);

	//searching
	//List<Post> findByTitleContaining(String title);

	//List<Post> findByTitleContaining(String keyword);

	//List<Post> searchByTitle(String string);


	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);
	
}
