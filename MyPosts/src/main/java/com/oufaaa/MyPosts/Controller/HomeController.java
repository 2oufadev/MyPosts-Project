package com.oufaaa.MyPosts.Controller;

import java.awt.Checkbox;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oufaaa.MyPosts.Entity.Post;
import com.oufaaa.MyPosts.Exceptions.EmptySearchException;
import com.oufaaa.MyPosts.Security.UserDetailsClass;
import com.oufaaa.MyPosts.Service.PostService;

@Controller
public class HomeController {
	
	private String username;
	
	
	
	@Autowired
	PostService postService;

	@RequestMapping("/")
	public ModelAndView Home() {
		ModelAndView mav=new ModelAndView();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		UserDetailsClass udc=(UserDetailsClass)auth.getPrincipal();
		username=udc.getUsername();
		List<Post> posts=postService.getUserPosts(username);
		mav.setViewName("profile");
		mav.addObject("postslist", posts);
		System.out.println(posts);
		return mav;
	}
	

	@RequestMapping("/login")
	public ModelAndView goToProfile() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home");

		
		return mav;
	}
	
	@PostMapping("/writepost")
	public ModelAndView published(@RequestParam("postcontent") String content,@RequestParam("status") String status) {
		

		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
		String datformated=sdf.format(date);
		Post post=new Post();
		post.setContent(content);
		post.setUsername(username);
		post.setDate_created(datformated);
		post.setStatus(status);
		if(postService.publish(post)) {
			System.out.println("saved");
		}else {
			System.out.println("not saved");

		}

		ModelAndView mav=new ModelAndView();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		UserDetailsClass udc=(UserDetailsClass)auth.getPrincipal();
		username=udc.getUsername();
		List<Post> posts=postService.getUserPosts(username);
		mav.setViewName("profile");
		mav.addObject("postslist", posts);
		return mav;

		
	}
	
	@PostMapping("/search")
	public ModelAndView searchPosts(@RequestParam("searchtext") String text) {
		ModelAndView mav=new ModelAndView();

		if(text.trim().isEmpty()) {
			throw new EmptySearchException("Search Text Cant Be Empty");
		}else {
			List<Post> matchedposts = postService.getSearchedPosts(text);
			mav.addObject("matchedposts",matchedposts);
		}
		
		mav.setViewName("searchmatch");
		return mav;
	}
	
	@PostMapping("/searchapi")
	@ResponseBody
	public List<Post> searchPostsApi(@RequestParam("searchtext") String text) {
		List<Post> matchedposts =null;

		if(text.trim().isEmpty()) {
			 throw new EmptySearchException("Search Text Cant Be Empty");
			
		}else {
		 matchedposts = postService.getSearchedPosts(text);
			
		}
		
	
		return matchedposts;
	}

}
