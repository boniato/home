package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.home.post.PostService;

@RestController
public class HomeController {
	
	@Autowired
	private PostService postService;

	
}
