package blog.service;

import blog.entity.Blog;
import blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IBlogService {
    void addNew(Blog blog);

    List<Blog> findAll();

    Blog findById(int id);

    void update(Blog blog);

    void delete(Blog blog);

//    List<Blog> findAllByCategory_CategoryNameContaining(String category);

    Slice<Blog>findAllByCategory_CategoryNameContainingOrTitleContainingOrContentContainingOrTimeContaining(String category_categoryName, String title, String content, String time, Pageable pageable);

    Slice<Blog>findAllWithSlice(Pageable pageable);

    Page<Blog>findAllWithPage(Pageable pageable);

//    Slice<Blog>SortByTime(Pageable pageable);

//    List<Blog> getBlogsByOrder(String order);
}
