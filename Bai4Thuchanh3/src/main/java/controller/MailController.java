package controller;


import model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import service.IMailService;
import service.MailService;

import java.util.ArrayList;
import java.util.Arrays;


@Controller
@RequestMapping("/mail")
public class MailController {

    private final IMailService mailService = new MailService();
    private ArrayList<String> languages = new ArrayList<>(Arrays.asList("English","Vietnamese","Japanese","Chinese"));
    private ArrayList<Integer> pageSize = new ArrayList<>(Arrays.asList(5,10,15,25,50,100));

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("mail", mailService.view());
        return "/index";
    }

    @GetMapping("/edit")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mail",mailService.view());
        modelAndView.addObject("pagesize",pageSize);
        modelAndView.addObject("languages", languages);
        modelAndView.setViewName("/edit");
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute Mail mail) {
        ModelAndView modelAndView = new ModelAndView();
        mailService.save(mail);
        modelAndView.addObject("mail",mailService.view());
        modelAndView.addObject("message","Success");
        modelAndView.addObject("pagesize",pageSize);
        modelAndView.addObject("languages", languages);
        modelAndView.setViewName("/edit");
        return modelAndView;
    }
}
