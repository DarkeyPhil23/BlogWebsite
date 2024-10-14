package josh.dev.BlogWebsite.Post;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private void createPost(@RequestBody PostDto postDto){
        postService.CreatePost(postDto);
    }


}
