package quanganh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import quanganh.model.User;
import quanganh.service.UserService;
import quanganh.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService = new UserServiceImpl();

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("user", userService.findAll());
        return "list";
    }

    @GetMapping("/user/{id}/edit")
    public String checkValidation(
            @PathVariable int id,
            Model model
    ) {
        model.addAttribute("edit", userService.findById(id));
        return "edit";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("create", new User());
        return "create";
    }

    @PostMapping("/user/create")
    public String create(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasFieldErrors()) {
            new User().validate(user, bindingResult);
            return "create";
        } else {
            int id = (int) (Math.random() * 100);
            user.setId(id);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "xxx");
            return "redirect:/";
        }

    }

    @PostMapping("/user/update")
    public String update(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("edit", user);
            return "edit";
        } else {
            userService.update(user.getId(), user);
            redirectAttributes.addFlashAttribute("message", "xxx");
            return "redirect:/";
        }
    }


}
