package josh.dev.BlogWebsite.Post;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    String title;
    String content;
    LocalDateTime DateCreated;
}
