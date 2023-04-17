package shopping_cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import shopping_cart.model.Product;
import shopping_cart.repository.IProductRepository;

import java.util.List;

@Service
@SessionScope
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public void add(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }


}
