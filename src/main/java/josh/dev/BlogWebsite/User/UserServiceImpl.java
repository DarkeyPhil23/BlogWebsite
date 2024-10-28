package josh.dev.BlogWebsite.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    private final AuthenticationManager authmanager;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, AuthenticationManager authmanager) {
        this.userRepo = userRepo;
        this.authmanager = authmanager;
    }


    @Override
    public User signUp(User user) {
        Optional<User> userFound = Optional.ofNullable(userRepo.findByusername(user.getUsername()));
        if (userFound.isPresent() && Objects.equals(user.getUsername(), userFound.get().getUsername()) &&
                Objects.equals(user.getEmail(), userFound.get().getEmail())){
            throw new UserFoundException();
        }
        // if no user exists encrypt

        user.setPassword(bcrypt.encode(user.getPassword()));


       return userRepo.save(user);
    }

    @Override
    public String verify(User user) {
        Authentication authentication = authmanager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){
            return  "success";
        }
        return "fail";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Handle updates to user
    // Gotta make sure we only call via Username
    @Override
    public void updateUser(User user) throws UsernameNotFoundException {
        Optional<User> userFound = Optional.of(userRepo.findByusername(user.getUsername()));

        if (userFound.isEmpty()){
            throw new UsernameNotFoundException("Username doesn't exist");
        }
    user.setPassword(bcrypt.encode(user.getPassword()));
    userRepo.save(user);

    }

    @Override
    public void deleteUser(User user) {
        Optional<User> userFound = Optional.of(userRepo.findByusername(user.getUsername()));

        if (userFound.isEmpty()){
            throw new UsernameNotFoundException("Username doesn't exist");
        }
        userRepo.delete(user);

    }
}
