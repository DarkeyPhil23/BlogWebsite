package josh.dev.BlogWebsite.User;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

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

    // TODO: Test this
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private void register(@RequestBody User user){

        userService.signUp(user);
    }

    // TODO: Test this:
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    private void login(@RequestBody User user){

        if( userService.verify(user).equals("Success")) {

        };
    }


    // TODO : Also test this
    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }


    @ExceptionHandler({UserFoundException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity handleUserFoundException(){
        return new ResponseEntity("Invalid Account. Please try another credentials",HttpStatusCode.valueOf(401));
    }
    @ExceptionHandler({UsernameNotFoundException.class})
    public ResponseEntity handleUsernameNotFoundException(){
        return new ResponseEntity("User doesn't exist",HttpStatusCode.valueOf(404));
    }


}
