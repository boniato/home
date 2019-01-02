package com.home.comment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.home.post.Post;
import com.home.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Lee on 2019.01.02
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private LocalDateTime regDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	private Post post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	
	@Builder
	public Comment(String content, Post post, User user) {
		this.content = content;
		this.post = post;
		this.user = user;
	}
}