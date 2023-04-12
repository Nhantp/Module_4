package product_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_manager.model.Product;
import product_manager.repository.IProductRepository;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }
}
