package product_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product_manager.model.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
