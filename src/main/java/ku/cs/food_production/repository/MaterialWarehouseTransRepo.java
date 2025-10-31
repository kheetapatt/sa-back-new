package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialWarehouseTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialWarehouseTransRepo extends JpaRepository<MaterialWarehouseTrans, Integer> {
}
