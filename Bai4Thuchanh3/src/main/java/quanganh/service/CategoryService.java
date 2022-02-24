package quanganh.service;

import org.springframework.beans.factory.annotation.Autowired;
import quanganh.model.Category;
import org.springframework.stereotype.Service;
import quanganh.repository.ICategoryRepository;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return  categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
