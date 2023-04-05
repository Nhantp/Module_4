package form_user.controller;

import form_user.model.User;
import form_user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("user",iUserService.findAll());
        return "/list";
    }
}