package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shopping_cart.model.Cart;
import shopping_cart.model.Product;
import shopping_cart.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String display(Model model){
        model.addAttribute("products",iProductService.findAll());
        return "product/shop";
    }
    @GetMapping("check/{id}")
    public String showCheck(@PathVariable Long id, Model model){
        model.addAttribute("products",iProductService.findById(id));
        return "product/check";
    }

    @GetMapping("/add/{id}")
    private String addToCart(@PathVariable("id") Product product,
                             @ModelAttribute("cart") Cart cart,
                             @RequestParam("action") String action) {
        if (product == null) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        } else if (action.equals("info")) {
            cart.addProduct(product);
            return "redirect:/info/" + product.getId();
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
}
