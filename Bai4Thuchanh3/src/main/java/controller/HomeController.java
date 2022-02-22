package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogService;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listblogs",blogService.findAll());
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
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("blog",blogService.findById(id));
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
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("blog",blogService.findById(id));
        modelAndView.setViewName("delete");
        return  modelAndView;
    }

    @PostMapping("delete")
    public ModelAndView delete(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Delete Success!");
        modelAndView.addObject("listblogs",blogService.findAll());
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
