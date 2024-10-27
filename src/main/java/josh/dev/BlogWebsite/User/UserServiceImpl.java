package josh.dev.BlogWebsite.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User signUp(User user) {
        user.setPassword(bcrypt.encode(user.getPassword()));
       return userRepo.save(user);
    }

    @Override
    public User loginUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
