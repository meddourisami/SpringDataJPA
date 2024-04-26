package tp.fst.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.fst.tp.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
