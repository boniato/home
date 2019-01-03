package com.home.post;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * Created by Lee on 2019.01.03
 */

@Data
public class PostDto {

	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String content;

	private Long categoryId;

	private String categoryName;
}
