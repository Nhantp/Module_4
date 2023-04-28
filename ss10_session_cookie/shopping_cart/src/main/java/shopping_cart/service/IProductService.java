package shopping_cart.service;


import shopping_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product>findAll();
    Optional<Product> findById(Long id);
    void delete(Product product);
}
