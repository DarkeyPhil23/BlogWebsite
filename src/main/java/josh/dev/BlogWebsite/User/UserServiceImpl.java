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
    private final JWTService jwtService;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, AuthenticationManager authmanager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.authmanager = authmanager;
        this.jwtService = jwtService;
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
            return jwtService.generateToken(user.getUsername(), userRepo.findByusername(user.getUsername()).getUserid());
        }
        return "fail";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Handle updates to user
    // Gotta make sure we only call via Username
    // Gotta implement DTO pattern here to avoid
    @Override
    public void updateUser(User user, Long id) throws UsernameNotFoundException {
        Optional<User> userFound = Optional.ofNullable(userRepo.getReferenceById(id));
    System.out.println(userFound);

            // Update fields as necessary; skip username if it’s meant to stay the same
            if(userFound.isPresent()){
                // TODO: Add existing username check to update username if it's not taken
                User existinguser = userFound.get();
                existinguser.setPassword(bcrypt.encode(user.getPassword()));
                existinguser.setEmail(user.getEmail());
                userRepo.save(existinguser);
            }else{
                throw new UsernameNotFoundException("User doesn't exist");
            }


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
