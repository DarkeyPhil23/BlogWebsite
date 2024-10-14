package josh.dev.BlogWebsite.Index;


import josh.dev.BlogWebsite.Post.Post;
import josh.dev.BlogWebsite.Post.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class IndexController {
    private  PostServiceImpl postService;

    @Autowired
    public IndexController(PostServiceImpl postService ) {
        this.postService = postService;
    }


    @GetMapping("")
    public ResponseEntity<Page<Post>> load(@RequestParam(defaultValue = "0")int pageNo, @RequestParam(defaultValue = "10")
    int pageSize ){
        return new ResponseEntity<>(postService.getAllPosts(pageNo,pageSize), HttpStatusCode.valueOf(200));
    }


}
