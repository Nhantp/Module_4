package codegym.vn.repository;

import codegym.vn.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product>findAll();
    void addNew(Product product);
    void update(Product product);
    void remove(int id);
    Product findById(int id);
    List<Product>searchByName(String name);
}
