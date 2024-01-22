package com.example.InteriorProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController2 {
	
	/*
	@GetMapping("/post")
	public String demoPost() {
		
		return "/post/post";  // post.html
	}
	*/
	
	@PostMapping("/post")
	public String demoPost( 
			@RequestParam String a,
			@RequestParam String b,
			@RequestParam String c, 
			Model model ) {
		
		model.addAttribute( "membername", a );
		model.addAttribute( "memberid", b );
		model.addAttribute( "memberemail", c );
		
		return "/post/post";  // post.html
	}
}















