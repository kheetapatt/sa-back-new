package ku.cs.food_production.repository;

import ku.cs.food_production.entity.ProductQc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQcRepo extends JpaRepository<ProductQc, Integer> {
}
