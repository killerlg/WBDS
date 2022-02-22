package service;

import model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Blog blog);
}
