package blog.service;

import blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    void addNew(Category category);
    List<Category> findAll();
    void delete(Category category);
    Category findById(int id);
    void update(Category category);

}
