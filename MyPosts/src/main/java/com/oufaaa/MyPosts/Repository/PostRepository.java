package com.oufaaa.MyPosts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oufaaa.MyPosts.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUsernameOrderByPostidDesc(String username);
	
	@Query("from Post p where p.status = 'public' and p.content like %:searchtext%")
	List<Post> getSearchList(@Param("searchtext") String searchtext);
}
