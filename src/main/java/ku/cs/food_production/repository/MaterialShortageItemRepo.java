package ku.cs.food_production.repository;

import ku.cs.food_production.entity.MaterialShortageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialShortageItemRepo extends JpaRepository<MaterialShortageItem, Integer> {
}
