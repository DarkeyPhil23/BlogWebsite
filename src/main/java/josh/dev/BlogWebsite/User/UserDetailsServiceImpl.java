package josh.dev.BlogWebsite.User;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepo;


    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByusername(username);
        if(user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);

    }
}
