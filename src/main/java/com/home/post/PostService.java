package com.home.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * Created by Lee on 2019.01.02
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

	@Autowired
	private PostRepository postRepository;
	

	@Transactional(readOnly = true)
	public List<Post> findAll() {
		List<Post> list = postRepository.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Post findByIdAndStatus(Long id, PostStatus status) throws NotFoundException {
		Post post = postRepository.findByIdAndStatus(id, status);
		
		if (post == null)
			throw new NotFoundException(id + " not found");
		
		return post;
	}
	
}
