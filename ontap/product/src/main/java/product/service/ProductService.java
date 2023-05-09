package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import product.model.Category;
import product.model.Product;
import product.repository.ICategoryRepository;
import product.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findProductById(Integer productId) {
        return iProductRepository.findById(productId).orElse(null);
    }

    @Override
    public void update(Product product) {
        Optional<Category>category=iCategoryRepository.findById(product.getCategory().getCategoryId());
        product.setCategory(category.orElse(null));
        iProductRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Slice<Product> searchAll(String categoryName, String description,String productName,Pageable pageable) {
        return iProductRepository.findAllByCategoryCategoryNameContainingOrDescriptionContainingOrProductNameContaining(categoryName,description,productName,pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }
}
