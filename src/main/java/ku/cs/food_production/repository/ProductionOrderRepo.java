package ku.cs.food_production.repository;

import ku.cs.food_production.entity.Material;
import ku.cs.food_production.entity.Product;
import ku.cs.food_production.entity.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductionOrderRepo extends JpaRepository<ProductionOrder, Integer> {
    List<ProductionOrder> findAllByCreationDate(LocalDateTime createdAt);
    List<ProductionOrder> findAllByProduct(Product product);
    List<ProductionOrder> findAllByCreatedAt(LocalDate createdAt);
}
