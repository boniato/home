package com.home.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lee on 2019.01.02
 */
public interface PostRepository extends JpaRepository<Post, Long> {
	
	public Post findByIdAndStatus(Long id, PostStatus status);
	
}