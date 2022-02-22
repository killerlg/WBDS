package service;

import model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
    void delete(Comment comment);
    Comment findById(Long id);
}
