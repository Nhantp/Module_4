package blog.controller;

import blog.entity.Category;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/blog/create";
    }
    @GetMapping("delete")
    public String deleteCategory(@RequestParam(name = "id") Integer id){
        Category category=iCategoryService.findById(id);
        iCategoryService.delete(category);
        return "redirect:/category/list";
    }
    @GetMapping("update")
    public String showUpdate(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/update";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute(name = "category")Category category) {
        iCategoryService.update(category);
        return "redirect:/category/list";
    }
}

