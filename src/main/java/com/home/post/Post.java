package com.home.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.home.category.Category;
import com.home.comment.Comment;
import com.home.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Lee on 2019.01.02
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 500, nullable = false)
	@NotNull
	private String title;

	@Lob
	@NotNull
	private String content;
	
	@Enumerated(EnumType.STRING)
	private PostStatus status;

	private LocalDateTime regDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();

	@Builder
	public Post(String title, String content, PostStatus status, Category category, User user) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.category = category;
		this.user = user;
	}
	
	@Builder
	public Post(String title, String content, PostStatus status, LocalDateTime regDate, List<Comment> comments, Category category, User user) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.regDate = regDate;
		if(comments != null){
			this.comments = comments;
		}
		this.category = category;
		this.user = user;
	}
	
}
