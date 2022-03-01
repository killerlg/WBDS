package quanganh.model;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;
    private List<BlogDTO> blogs;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, List<BlogDTO> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogDTO> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogDTO> blogs) {
        this.blogs = blogs;
    }
}
