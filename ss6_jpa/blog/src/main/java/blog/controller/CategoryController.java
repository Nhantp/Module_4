package blog.controller;

import blog.entity.Category;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("category",iCategoryService.findAll());
        return "category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "category/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "category") Category category){
        iCategoryService.addNew(category);
        return "redirect:/category/list";
    }
}
