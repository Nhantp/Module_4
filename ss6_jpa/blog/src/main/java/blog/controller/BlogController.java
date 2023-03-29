package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.service.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
    IBlogService iBlogService;
    @Autowired
    private BlogController(IBlogService iBlogService){
        this.iBlogService=iBlogService;
    }
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("blog",iBlogService.findAll());
        return "/list";
    }
}
