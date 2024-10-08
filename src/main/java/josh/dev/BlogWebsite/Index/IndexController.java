package josh.dev.BlogWebsite.Index;


import josh.dev.BlogWebsite.Post.Dto.PostDto;
import josh.dev.BlogWebsite.Post.Service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {
    private  PostServiceImpl postService;

    public IndexController(PostServiceImpl postService) {
        this.postService = postService;
    }


    @GetMapping("")
    public ResponseEntity<List<PostDto>> load(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatusCode.valueOf(200));
    }

}
