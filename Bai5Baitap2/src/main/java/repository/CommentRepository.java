package repository;

import model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        if (id == null) {
            return null;
        }
        return em.find(Comment.class,id);
    }
    @Override
    public void save(Comment comment) {
        if (findById(comment.getId()) == null) {
            em.persist(comment);
        } else { em.merge(comment);}

    }

    @Override
    public void delete(Comment comment) {
        Comment comments = findById(comment.getId());
        if (comments != null) {
            em.remove(comments);
        }
    }
}
