package josh.dev.BlogWebsite.User;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {

      super("User Already exists please try another username");
    }
}
