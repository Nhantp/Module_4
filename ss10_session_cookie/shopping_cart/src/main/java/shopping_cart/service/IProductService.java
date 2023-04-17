package product_manager.service;

import product_manager.model.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    void save(Product product);
    Product findById(int id);
    void delete(Product product);
    void update(Product product);

}
