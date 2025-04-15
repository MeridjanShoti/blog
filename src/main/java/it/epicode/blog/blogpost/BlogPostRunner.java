package it.epicode.blog.blogpost;

import it.epicode.blog.common.FakerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BlogPostRunner implements CommandLineRunner {
    @Autowired
    BlogPostService blogPostService;
    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        if (blogPostRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                BlogPost blogPost = new BlogPost();
                blogPost.setCategoria(fakerConfig.faker().book().genre());
                blogPost.setTitolo(fakerConfig.faker().book().title());
                blogPost.setCover(fakerConfig.faker().internet().image());
                blogPost.setContenuto(fakerConfig.faker().lorem().paragraph(10));
                blogPost.setTempoDiLettura(fakerConfig.faker().number().numberBetween(1, 10));
                blogPostRepository.save(blogPost);
            }

        }
    }
}