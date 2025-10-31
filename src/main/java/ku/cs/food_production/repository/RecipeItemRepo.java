package ku.cs.food_production.repository;

import ku.cs.food_production.entity.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeItemRepo extends JpaRepository<RecipeItem, Integer> {
}
