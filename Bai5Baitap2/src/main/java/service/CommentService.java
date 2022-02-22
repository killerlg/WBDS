package service;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICommentRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository iCommentRepository;
    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        iCommentRepository.delete(comment);
    }

    @Override
    public Comment findById(Long id) {
        return iCommentRepository.findById(id);
    }
}
