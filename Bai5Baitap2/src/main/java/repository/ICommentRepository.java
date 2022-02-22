package repository;

import model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    void delete(Comment comment);

}
