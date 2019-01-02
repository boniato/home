package com.home.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import com.home.comment.Comment;
import com.home.post.Post;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2019.01.02
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
//@ToString(exclude = { "comments", "post" })
//@EqualsAndHashCode(exclude = { "comments", "post" })
public class User {
	
	@GeneratedValue
	@Id
	private Long id;
	private String email;
	private String name;
	private String github;
	private String url;

	/* To save that who writes posts or comments */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();

	@Column
	@Lob
	private String bio;

	
	@Builder
	public User(String email, String name, String github, String url) {
		this.email = email;
		this.name = name;
		this.github = github;
		this.url = url;
	}
	
}