package tp.fst.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp.fst.tp.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String keyword);
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x")String keyword);
}
