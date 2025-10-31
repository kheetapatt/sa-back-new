package ku.cs.food_production.repository;

import ku.cs.food_production.entity.ProductLot;
import ku.cs.food_production.entity.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductLotRepo extends JpaRepository<ProductLot, Integer> {
    List<ProductLot> findAllByCreatedAt(LocalDateTime createdAt);
}
