package com.home.category;

import lombok.*;
import com.home.post.Post;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2019.01.02
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private LocalDateTime regDate;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();

	
	@Builder
	public Category(String name, LocalDateTime regDate, List<Post> post) {
		this.name = name;
		this.regDate = regDate;
		this.post = post;
	}

}