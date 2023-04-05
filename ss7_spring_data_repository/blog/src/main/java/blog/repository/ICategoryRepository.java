package blog.repository;

import blog.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    void addNew(Category category);
    List<Category>findAll();
    void delete(Category category);
    Category findById(int id);
    void update(Category category);
}
