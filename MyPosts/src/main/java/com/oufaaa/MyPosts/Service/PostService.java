package com.oufaaa.MyPosts.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oufaaa.MyPosts.Entity.Post;
import com.oufaaa.MyPosts.Repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository pRepository;
	
	public List<Post> getUserPosts(String username){
	
		return pRepository.findByUsernameOrderByPostidDesc(username);
	
	}
	
	public boolean publish(Post post) {
		Post postt=pRepository.save(post);
		if(post.getContent().equals(postt.getContent())) {
			return true;
		}
		
		return false;
	}
	
	public List<Post> getSearchedPosts(String text){
		return pRepository.getSearchList(text);
		
	}
}
