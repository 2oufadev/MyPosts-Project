package com.oufaaa.MyPosts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oufaaa.MyPosts.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
