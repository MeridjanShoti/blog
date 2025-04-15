package it.epicode.blog.blogpost;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    public BlogPost save(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }
    public BlogPost update(Long id, BlogPost blogPost){
        if (!blogPostRepository.existsById(id)){
            throw new IllegalArgumentException("BlogPost non trovato");
        }else{
            BlogPost blogPost1 = blogPostRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(blogPost, blogPost1, "id");
            return blogPostRepository.save(blogPost1);
        }
    }
    public void delete(Long id){
        if (!blogPostRepository.existsById(id)){
            throw new IllegalArgumentException("BlogPost non trovato");
        } else {
            blogPostRepository.deleteById(id);
        }
    }
    public BlogPost findById(Long id){
        return blogPostRepository.findById(id).orElseThrow();
    }
    public List<BlogPost> findAll(){
        return blogPostRepository.findAll();
    }

}
