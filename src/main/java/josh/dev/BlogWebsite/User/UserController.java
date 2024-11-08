package josh.dev.BlogWebsite.User;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    //fine
    @GetMapping("")
    ResponseEntity getUsers (){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatusCode.valueOf(200));
    }

    // fine
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private void register(@RequestBody User user){

        userService.signUp(user);
    }
// fine
    @PostMapping("/login")
    private ResponseEntity login(@RequestBody User user){
        String token = userService.verify(user);
        if(userService.verify(user).equalsIgnoreCase("fail")) {
            System.out.println( "Inside: " + userService.verify(user));
           throw new UserNotAuthenticatedException();
        };
        System.out.println("Outside: " + token);
        return new ResponseEntity(token , HttpStatusCode.valueOf(200));
    }

    // fine
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateUser(@RequestBody User user, @PathVariable Long id){
        System.out.println(user);
        System.out.println("id here:" + id);
        userService.updateUser(user,id);
    }
    @ExceptionHandler({UserNotAuthenticatedException.class})
    public ResponseEntity handleBadCrdentialsAuth(){
        return new ResponseEntity("Invalid Username/Password.",HttpStatusCode.valueOf(403));
    }

    @ExceptionHandler({UserFoundException.class})
    public ResponseEntity handleUserFoundException(){
        return new ResponseEntity("Username already exists please choose another one.",HttpStatusCode.valueOf(401));
    }
    @ExceptionHandler({ SQLIntegrityConstraintViolationException.class})
    public ResponseEntity handleSQLConstraint(){
        return new ResponseEntity("You are trying to register an existing user. ",HttpStatusCode.valueOf(401));
    }
    @ExceptionHandler({UsernameNotFoundException.class})
    public ResponseEntity handleUsernameNotFoundException(){
        return new ResponseEntity("User doesn't exist",HttpStatusCode.valueOf(404));
    }


}
