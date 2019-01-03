package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.category.Category;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.home.user.User;
import com.home.util.Navigation;
import com.home.util.Section;
import com.home.comment.CommentDto;
import com.home.post.Post;
import com.home.post.PostDto;
import com.home.post.PostService;
import com.home.post.PostStatus;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;


/**
 * Created by Lee on 2019.01.02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Navigation(Section.POST)
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
			throw new NotFoundException(id + " not found!!");
		
		model.addAttribute("post", post);
		return "post/post";
	}
	
	@RequestMapping
	public String createPost(@ModelAttribute @Valid PostDto createPost, Model model,
			@AuthenticationPrincipal User user) {
		/*if (bindingResult.hasErrors()) {
			return "post/new";
		}*/
		Post post = new Post(createPost.getTitle(), createPost.getContent(), PostStatus.Y, new Category(createPost.getCategoryId()), user);
		Post newPost = postService.createPost(post);
		model.addAttribute("post", newPost);
		return "redirect:/posts/" + newPost.getId();
	}
	
	
}
