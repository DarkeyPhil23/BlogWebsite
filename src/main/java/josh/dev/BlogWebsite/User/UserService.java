package josh.dev.BlogWebsite.User;

import java.util.List;

public interface UserService {
    // POST method
    User signUp(User user);

    // login Method
    String verify(User user);

    // Get List
    List<User> getAllUsers();

    // UPDATE METHOD
    void updateUser(User user, Long id);

    //DELETE METHOD
    void deleteUser( User user);
}
