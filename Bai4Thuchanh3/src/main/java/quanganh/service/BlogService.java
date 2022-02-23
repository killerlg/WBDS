package quanganh.service;

import org.springframework.expression.spel.ast.Literal;
import quanganh.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quanganh.model.Category;
import quanganh.repository.IBlogRepository;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {

        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAllByContentContaining(String content, Pageable pageable) {
        return blogRepository.findAllByContentContaining(content,pageable);
    }
}
