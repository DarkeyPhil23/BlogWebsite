package josh.dev.BlogWebsite.Post;

import org.springframework.data.domain.Page;


interface PostService {
    // POST method
    void CreatePost(PostDto postDto);

    // Get Method
    PostDto getPost( PostDto postDto);
    PostDto getPost(Long id);

    // Get List
    Page<Post> getAllPosts(int pageNo, int pageSize);
//    List<PostDto> getIndexPosts();

    // UPDATE METHOD
    void updatePost(PostDto postDto);
    void updatePost(Long id);

    //DELETE METHOD
    void deletePost( PostDto postDto);
    void deletePost(Long id);

}
