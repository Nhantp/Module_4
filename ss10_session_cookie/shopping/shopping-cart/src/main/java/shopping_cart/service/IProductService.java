package shopping_cart.service;

import shopping_cart.model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void remove(Product product);
    Product findById(int id);
    List<Product>findAll();
}
