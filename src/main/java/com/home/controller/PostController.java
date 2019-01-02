package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.comment.CommentDto;
import com.home.post.Post;
import com.home.post.PostService;
import com.home.post.PostStatus;

import javassist.NotFoundException;


/**
 * Created by Lee on 2019.01.02
 */
@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Post> list = postService.findAll();
		model.addAttribute("list", list);

		return "post/list";
	}
	
	@GetMapping("/{id}")
	public String findByPost(@PathVariable Long id, Model model, @ModelAttribute CommentDto commentDto) throws NotFoundException {
		Post post = postService.findByIdAndStatus(id, PostStatus.Y);
		if (post == null)
			throw new NotFoundException(id + " not found");
		
		model.addAttribute("post", post);
		return "post/post";
	}
}
