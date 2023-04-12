package blog.repository;


import blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
