package josh.dev.BlogWebsite.Post.Service;

import jakarta.persistence.EntityNotFoundException;
import josh.dev.BlogWebsite.Post.Dto.PostDto;
import josh.dev.BlogWebsite.Post.Mapper.PostDtoMapper;
import josh.dev.BlogWebsite.Post.Model.Post;
import josh.dev.BlogWebsite.Post.Repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private PostDtoMapper postDtoMapper;


    @Override
    public void CreatePost(PostDto postDto) {
//        Add Converter of DateTime

        if((postDto.getDateCreated() == null)){
            postDto.setDateCreated(LocalDateTime.now());
        }
        System.out.print("Date Created here: " + postDto.getDateCreated());

       Post post = postDtoMapper.ConvertToEntity(postDto);
       postRepo.save(post);
    }

    @Override
    public PostDto getPost( PostDto postDto) {
        Optional<Post> findByTitle = Optional.ofNullable(postRepo.findByTitle(postDto.getTitle()));
        Optional<Post> findByDesc = Optional.ofNullable(postRepo.findByContent(postDto.getContent()));
        PostDto post;

        if(findByTitle.isPresent() && findByDesc.isEmpty()){
            post =  postDtoMapper.ConvertToDto(findByTitle.get());
        }
        else if (findByTitle.isEmpty()&& findByDesc.isPresent()){
            post =  postDtoMapper.ConvertToDto(findByDesc.get());
        }
        else if(findByTitle.isPresent() && findByDesc.isPresent()){
            post = postDtoMapper.ConvertToDto(findByTitle.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return post;
    }

    @Override
    public PostDto getPost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        if(post.isPresent()){
            return postDtoMapper.ConvertToDto(post.get());
        }
        else {
            throw new EntityNotFoundException("Id not found");
        }

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        List <PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            postDtos.add(postDtoMapper.ConvertToDto(post));
        }
        return postDtos;
    }
    @Override
    public void updatePost(PostDto postDto) {
        Optional<Post> findByTitle = Optional.ofNullable(postRepo.findByTitle(postDto.getTitle()));
        Optional<Post> findByDesc = Optional.ofNullable(postRepo.findByContent(postDto.getContent()));

        if(findByTitle.isPresent() || findByDesc.isPresent()){
            postRepo.save(postDtoMapper.ConvertToEntity(postDto)) ;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


    @Override
    public void updatePost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        if(post.isPresent()){
           postRepo.save(post.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public void deletePost(PostDto postDto) {
        Optional<Post> findByTitle = Optional.ofNullable(postRepo.findByTitle(postDto.getTitle()));
        Optional<Post> findByDesc = Optional.ofNullable(postRepo.findByContent(postDto.getContent()));

        if(findByTitle.isPresent() && findByDesc.isPresent()){
            postRepo.delete(postDtoMapper.ConvertToEntity(postDto)); ;
        }

    }

    @Override
    public void deletePost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        post.ifPresent(value -> postRepo.delete(value));

    }
}
