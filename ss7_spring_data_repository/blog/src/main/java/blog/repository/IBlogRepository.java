package blog.repository;


import blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog>findAllByCategory_CategoryNameContaining(String category);
    Page<Blog> findAllByCategory_CategoryNameContainingOrTitleContainingOrContentContainingOrTimeContaining(String category_categoryName, String title, String content, String time, Pageable pageable);
//    Page<Blog> sort(Sort sort);
//    List<Blog>findAlByOrderByTimeAsc()
}
