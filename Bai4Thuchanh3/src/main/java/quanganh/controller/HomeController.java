package quanganh.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import quanganh.model.Blog;
import quanganh.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import quanganh.service.IBlogService;
import quanganh.service.ICategoryService;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(Pageable pageable){
        return categoryService.findAll();
    }


    @GetMapping("")
    public ModelAndView index(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Blog> blogs;
        if(search.isPresent()){
            blogs = blogService.findAllByContentContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listblogs",blogs);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create");
        modelAndView.addObject("blog", new Blog());
        return  modelAndView;
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message","Add Success!");
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("blog",blogService.findById(id).get());
        modelAndView.setViewName("edit");
        return  modelAndView;
    }
    @PostMapping("edit")
    public ModelAndView saveEdit(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Edit Success");
        modelAndView.setViewName("edit");
        return  modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("blog",blogService.findById(id));
        modelAndView.setViewName("delete");
        return  modelAndView;
    }

    @PostMapping("delete")
    public ModelAndView delete(@PathVariable("id") Long id, Pageable pageable) {
        blogService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Delete Success!");
        modelAndView.addObject("listblogs",blogService.findAll(pageable));
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
