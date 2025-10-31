package ku.cs.food_production.repository;

import ku.cs.food_production.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAllByCreatedAt(LocalDate createdAt);
}
