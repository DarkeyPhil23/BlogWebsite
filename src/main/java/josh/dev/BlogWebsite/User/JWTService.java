package josh.dev.BlogWebsite.User;


import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

// TODO: Create a token generator, verifier, 
@Service
public class JWTService {
    String secretKey = "";

    public JWTService() {
    }

    public String generateToken() {
        // Jwts.builder
        return "";
    }
}
