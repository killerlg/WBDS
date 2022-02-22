package controller;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("like/{id}")
    public ModelAndView likes(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Long totalLikes = commentService.findById(id).getTotalLike();
        Comment comment = commentService.findById(id);
        comment.setTotalLike(totalLikes+1);
        commentService.save(comment);

        return new ModelAndView("redirect:/");
    }

}
