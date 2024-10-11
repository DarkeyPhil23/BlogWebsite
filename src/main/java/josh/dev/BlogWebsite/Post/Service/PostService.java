package josh.dev.BlogWebsite.Post.Service;

import josh.dev.BlogWebsite.Post.Dto.PostDto;
import josh.dev.BlogWebsite.Post.Model.Post;
import org.springframework.data.domain.Page;


public interface PostService {
    // POST method
    void CreatePost(PostDto postDto);

    // Get Method
    PostDto getPost( PostDto postDto);
    PostDto getPost(Long id);

    // Get List
    Page<Post> getAllPosts(int pageNo, int pageSize);

    // UPDATE METHOD
    void updatePost(PostDto postDto);
    void updatePost(Long id);

    //DELETE METHOD
    void deletePost( PostDto postDto);
    void deletePost(Long id);

}
