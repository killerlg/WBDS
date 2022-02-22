package repository;

import java.util.List;

public interface ICommentRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

}
