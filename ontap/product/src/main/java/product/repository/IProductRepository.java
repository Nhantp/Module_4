package product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import product.model.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByCategoryCategoryNameContainingOrDescriptionContainingOrProductNameContaining(String categoryName, String description, String productName, Pageable pageable);
}
