package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRequestRepo extends JpaRepository<MaterialRequest,Integer> {
}
