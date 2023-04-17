package shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping_cart.model.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
