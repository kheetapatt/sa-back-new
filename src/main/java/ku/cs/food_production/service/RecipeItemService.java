package ku.cs.food_production.service;

import ku.cs.food_production.repository.RecipeItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeItemService {
    private RecipeItemRepo repo;

    @Autowired
    public RecipeItemService(RecipeItemRepo repo) {
        this.repo = repo;
    }
}
