package service;

import model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
}
