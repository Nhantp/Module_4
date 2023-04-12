package blog.repository;

import blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
