package josh.dev.BlogWebsite.Post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PostDtoMapper {
    public static PostDto  ConvertToDto(Post post){
        // Add conversion of date time
        return PostDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .DateCreated(post.getDateCreated())
                .build();
    }
    public static Post ConvertToEntity(PostDto postDto){
        // TODO: add conversion to date time
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .dateCreated(postDto.getDateCreated())
                .build();
    }
}
