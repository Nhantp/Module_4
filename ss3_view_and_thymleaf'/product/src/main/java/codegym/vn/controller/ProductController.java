package codegym.vn.controller;

import codegym.vn.model.Product;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("list")
    public String Display(Model model){
        model.addAttribute("product",productService.findAll());
        return "product/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "product/create";
    }
    @PostMapping("create")
    public String doCreate(@ModelAttribute(name = "product") Product product){
        productService.addNew(product);
        return "redirect:/product/list";
    }
    @GetMapping("/{id}/delete")
    public String remove(Model model,@PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        productService.remove(id);
        return "redirect:/product/list";
    }
    @GetMapping("{id}/update")
    public String showUpdate(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        return "/product/update";
    }
    @PostMapping("/update")
    public String doUpdate(Product product){
        productService.update(product);
        return "redirect:/product/list";
    }
    @GetMapping("/{id}/check")
    public String findById(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/list";
    }
    @GetMapping("/search")
    public String showSearch(Model model){
        model.addAttribute("product",new Product());
        return "product/search";
    }
    @PostMapping("/search")
    public String search(Model model, String name,@ModelAttribute(value = "product")Product product){
        model.addAttribute("product",productService.searchByName(name));
        return "product/list";
    }

}
