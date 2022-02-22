package repository;

import model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CommentRepository implements ICommentRepository<Comment>{
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
}
