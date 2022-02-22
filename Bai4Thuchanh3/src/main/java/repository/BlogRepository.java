package repository;

import model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Integer id) {
        if (id == null) {
            return null;
        }
        return em.find(Blog.class,id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }

    @Override
    public void delete(Blog blog) {
        Blog blogs = findById(blog.getId());
        if (blogs != null) {
            em.remove(blogs);
        }
    }
}
