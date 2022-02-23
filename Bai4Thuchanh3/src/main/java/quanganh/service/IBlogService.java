package quanganh.service;

import org.springframework.expression.spel.ast.Literal;
import org.springframework.stereotype.Service;
import quanganh.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quanganh.model.Category;

import java.util.Optional;
@Service
public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Optional<Blog> findById(Long id);
    void save(Blog blog);
    void delete(Long id);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
