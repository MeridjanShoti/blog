package it.epicode.blog.blogpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;
    @GetMapping
    public List<BlogPost> getAll(){
        return blogPostService.findAll();
    }
    @GetMapping("/{id}")
    public BlogPost getById(@PathVariable Long id){
        return blogPostService.findById(id);
    }
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public BlogPost save(@RequestBody BlogPost blogPost){
        return blogPostService.save(blogPost);
    }
    @PutMapping("/{id}")
    public BlogPost update(@PathVariable Long id, @RequestBody BlogPost blogPost){
        return blogPostService.update(id, blogPost);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        blogPostService.delete(id);
    }
}
