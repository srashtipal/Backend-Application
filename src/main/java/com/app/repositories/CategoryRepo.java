package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Post;

public interface CategoryRepo  extends JpaRepository<Category,Integer>{

	//List<Post> findByCategory(Category category);	

}
