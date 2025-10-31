package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialQc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialQcRepo extends JpaRepository<MaterialQc,Integer> {
}
