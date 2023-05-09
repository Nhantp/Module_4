package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.model.Category;
import product.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository icategoryRepository;
    @Override
    public List<Category> findAll() {
        return icategoryRepository.findAll();
    }

    @Override
    public Category findProductById(Integer categoryId) {
        return icategoryRepository.findById(categoryId).orElse(null);
    }
}
