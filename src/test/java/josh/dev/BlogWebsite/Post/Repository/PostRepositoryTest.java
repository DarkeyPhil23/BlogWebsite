package josh.dev.BlogWebsite.Post.Repository;

import josh.dev.BlogWebsite.Post.Post;
import josh.dev.BlogWebsite.Post.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepo;
    private Post post;

    @BeforeEach
   public void setUp() {
        post = Post.builder()
                .title("Great Gatsby")
                .content("This is a post about Great Gatsby")
                .dateCreated(LocalDateTime.of(2024,10,6,12,0))
                .build();

        System.out.println(post);

    }

    @Test
    public void givenPostObject_WhenSave_SavedPostObject(){
        Post savedPost = postRepo.save(post);

        Assertions.assertThat(savedPost).isNotNull();

    }
    @Test
    public void givenPostObject_WhenSave_PostisequalToOne(){
        Post savedPost = postRepo.save(post);

        Assertions.assertThat(savedPost.getId()).isBetween(1L,10L);

    }
    @Test
    public void givenPostObject_WhenSave_PostRepoisNotEqualToZero(){
        Post savedPost = postRepo.save(post);

        Assertions.assertThat(postRepo.count()).isGreaterThan(0);

    }
}