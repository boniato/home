package com.home.post;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.home.category.Category;
import com.home.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	
	User user = null;
	Category category = null;
	
	
	@Autowired
	PostRepository postRepository;
	
	
	@Before
	public void setUp() throws Exception {
		user = new User("lee@mail.com", "Lee", "github", "url");
		category = new Category("Lee", LocalDateTime.now(), null);
    }
	
	@After
    public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
    public void openSavedContent() {
		
        //given
		postRepository.save(Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .status(PostStatus.Y)
                .regDate(LocalDateTime.now())
                .comments(null)
                .build());

        //when
        List<Post> postsList = postRepository.findAll();

        //then
        Post post = postsList.get(0);
        assertThat(post.getTitle(), is("테스트 제목"));
        assertThat(post.getContent(), is("테스트 내용"));
    }
}
