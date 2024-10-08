package josh.dev.BlogWebsite.Post.Controllers;


import josh.dev.BlogWebsite.Post.Dto.PostDto;
import josh.dev.BlogWebsite.Post.Service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private void createPost(@RequestBody PostDto postDto){
        postService.CreatePost(postDto);
    }


}
