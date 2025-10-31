package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialShortage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialShortageRepo extends JpaRepository<MaterialShortage, Integer> {
}
