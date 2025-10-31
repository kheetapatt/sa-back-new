package ku.cs.food_production.repository;

import ku.cs.food_production.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
}
