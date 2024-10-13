package josh.dev.BlogWebsite.Post.Repository;

import josh.dev.BlogWebsite.Post.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String text);
    Post findByContent(String text);
    
}
