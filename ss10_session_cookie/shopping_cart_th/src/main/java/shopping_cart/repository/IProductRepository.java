package shopping_cart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shopping_cart.model.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
