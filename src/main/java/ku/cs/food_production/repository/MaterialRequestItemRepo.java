package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialRequestItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRequestItemRepo extends JpaRepository<MaterialRequestItem, Integer> {
}
