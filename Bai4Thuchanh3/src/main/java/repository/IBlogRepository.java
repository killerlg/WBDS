package repository;

import model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Blog blog);
}
