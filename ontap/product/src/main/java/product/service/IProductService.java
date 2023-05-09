package product.service;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import product.model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);

    List<Product> findAll();

    Product findProductById(Integer productId);

    void update(Product product);

    void delete(Product product);

    Slice<Product> searchAll(String categoryName, String description, String productName,Pageable pageable);

    Slice<Product> findAllWithSlice(Pageable pageable);
}
