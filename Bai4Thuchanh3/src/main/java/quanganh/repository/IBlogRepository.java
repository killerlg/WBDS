package quanganh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quanganh.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import quanganh.model.Category;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
