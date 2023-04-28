package blog.service.impl;

import blog.entity.Category;
import blog.repository.IBlogRepository;
import blog.repository.ICategoryRepository;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public void addNew(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void delete(Category category) {
        iCategoryRepository.delete(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

}
