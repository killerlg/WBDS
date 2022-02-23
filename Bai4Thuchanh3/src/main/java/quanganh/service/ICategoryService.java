package quanganh.service;

import org.springframework.stereotype.Service;
import quanganh.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
@Service
public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category category);
    void delete(Category category);
}
