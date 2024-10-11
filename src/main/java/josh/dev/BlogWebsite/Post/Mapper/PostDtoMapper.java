package josh.dev.BlogWebsite.Post.Mapper;

import josh.dev.BlogWebsite.Post.Dto.PostDto;
import josh.dev.BlogWebsite.Post.Model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PostDtoMapper {
    public PostDto ConvertToDto(Post post){
        // Add conversion of date time
        return new PostDto(post.getTitle(), post.getContent(), post.getDateCreated());
    }
    public Post ConvertToEntity(PostDto postDto){
        // TODO: add conversion to date time
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .dateCreated(postDto.getDateCreated())
                .build();
    }
}
