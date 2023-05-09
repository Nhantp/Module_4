package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shopping_cart.model.Product;
import shopping_cart.service.IProductService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("view")
    public String viewProduct(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "/view-products";
    }

    @GetMapping("check")
    public String checkProduct(@RequestParam("id") Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("products",product);
        return "check-products";
    }
    @GetMapping("index")
    public String index(){
        return "demo";
    }

}
