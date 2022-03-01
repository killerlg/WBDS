package quanganh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quanganh.model.BlogDTO;
import quanganh.model.Category;
import quanganh.model.CategoryDTO;
import quanganh.service.ICategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Iterable<CategoryDTO>> findAllCategories() {
        List<Category> categories = (List<Category>)categoryService.findAll();
        List<CategoryDTO> categoriesDTO = categories.stream().map(
                e -> new CategoryDTO(e.getId(),e.getName(),e.getBlogs().stream().map(
                        m -> new BlogDTO(m.getId(),m.getTitle())
                ).collect(Collectors.toList()))
        ).collect(Collectors.toList());
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryByID(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(categoryService.findById(id).get());
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.NO_CONTENT);
    }

}
