package josh.dev.BlogWebsite.User;

import java.util.List;

public interface UserService {
    // POST method
    User signUp(User user);

    // Get Method
    User loginUser(User user);

    // Get List
    List<User> getAllUsers();

    // UPDATE METHOD
    void updateUser(User user);

    //DELETE METHOD
    void deleteUser( User user);
}
