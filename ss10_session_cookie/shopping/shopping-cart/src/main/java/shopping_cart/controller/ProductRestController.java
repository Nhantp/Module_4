package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopping_cart.model.Product;
import shopping_cart.service.IProductService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v2/product")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @PostMapping("/update-total")
    public Double updateTotalPrice(@RequestParam Integer productId, @RequestParam Integer newQuantity) {
        Product product = iProductService.findById(productId);
        return product.getPrice() * newQuantity;
    }
}
