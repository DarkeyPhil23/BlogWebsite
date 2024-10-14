package josh.dev.BlogWebsite.Post;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import josh.dev.BlogWebsite.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "POSTS")
public class Post {
    @Id
    @SequenceGenerator( // a primary key generator
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1 // specify the amount by which the sequence value should be incremented when obtaining a block of values from the database sequence
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence")
   private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(max = 255)
    private String title;

    @Lob
    @Column(name="text", length = 65536)
    private String content;

    private LocalDateTime dateCreated;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private User user;

}
