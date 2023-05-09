package product.service;

import product.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category>findAll();
    Category findProductById(Integer categoryId);
}
