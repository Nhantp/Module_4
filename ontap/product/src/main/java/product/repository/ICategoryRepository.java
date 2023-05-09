package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.model.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
