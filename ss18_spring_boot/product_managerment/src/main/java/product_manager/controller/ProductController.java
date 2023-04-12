package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import product_manager.model.Product;
import product_manager.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("list")
    public String display(Model model){
        model.addAttribute("products",iProductService.findAll());
        return "product/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }
    @PostMapping("create")
    public String doCreate(@ModelAttribute(name = "product") Product product){
        iProductService.save(product);
        return "redirect:/product/list";
    }
    @GetMapping("update/{id}")
    public String showUpdate(Model model,@PathVariable int id){
        model.addAttribute("product",iProductService.findById(id));
        return "product/update";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute(name = "product")Product product){
        iProductService.update(product);
        return "redirect:/product/list";
    }
}
