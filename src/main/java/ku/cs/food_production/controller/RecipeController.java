package ku.cs.food_production.controller;

import ku.cs.food_production.dto.RecipeMaterialDto;
import ku.cs.food_production.entity.Recipe;
import ku.cs.food_production.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping("/products/recipe/{productId}")
    public Recipe add(@RequestBody List<RecipeMaterialDto> materials, @PathVariable int productId) {
        return service.add(materials, productId);
    }

    @GetMapping("/products/recipe/{productId}")
    public List<RecipeMaterialDto> getRecipe(@PathVariable int productId) {
        return service.getRecipe(productId);
    }
}
