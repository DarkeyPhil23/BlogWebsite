package josh.dev.BlogWebsite.User;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    ResponseEntity getUsers (){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatusCode.valueOf(200));
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private void register(@RequestBody User user){
        userService.signUp(user);
    }

}
