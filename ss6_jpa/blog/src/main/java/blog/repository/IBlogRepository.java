package blog.repository;


import blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    void addNew(Blog blog);
    List<Blog>findAll();
    Blog findById(int id);
    void update(Blog blog);
}
