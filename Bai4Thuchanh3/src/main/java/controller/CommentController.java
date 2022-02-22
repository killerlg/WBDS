package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICommentService;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("")
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("listcomments",commentService.findAll());
        modelAndView.setViewName("index");
        return  modelAndView;
    }

    @PostMapping("save")
    public ModelAndView addComment(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("message","Add Success!");
        modelAndView.addObject("listcomments",commentService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
