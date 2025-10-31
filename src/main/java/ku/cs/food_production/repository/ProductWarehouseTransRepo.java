package ku.cs.food_production.repository;

import ku.cs.food_production.entity.ProductWarehouseTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWarehouseTransRepo extends JpaRepository<ProductWarehouseTrans, Integer> {
}
