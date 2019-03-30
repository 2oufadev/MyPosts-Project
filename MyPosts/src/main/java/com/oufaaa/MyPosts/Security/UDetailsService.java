package com.oufaaa.MyPosts.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oufaaa.MyPosts.Entity.User;
import com.oufaaa.MyPosts.Repository.UserRepository;

@Service
public class UDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository uRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=uRepository.findByUsername(username);
		
		if(user==null) {
            throw new UsernameNotFoundException("User Not Found");
     }
		return new UserDetailsClass(user);
	}

}
