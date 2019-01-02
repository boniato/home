package com.home.comment;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CommentDto {

	@NotNull
	private Long postId;

	@NotNull
	private String content;
}