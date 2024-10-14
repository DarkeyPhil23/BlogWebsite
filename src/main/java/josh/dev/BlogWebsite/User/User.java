package josh.dev.BlogWebsite.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import josh.dev.BlogWebsite.Post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "USER")
public class User {

    @Id
    @SequenceGenerator( // a primary key generator
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    private long userid;
    @Column(unique = true, nullable = false)
    @NotNull
    private String username;

    @Column(
            nullable = false
    )
    @NotNull
    private String password;


    private String email;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;



// TODO: Add implementation for security authorization and authentitcaiotn
}
