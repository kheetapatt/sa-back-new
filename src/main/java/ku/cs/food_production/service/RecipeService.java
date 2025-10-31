package ku.cs.food_production.service;

import ku.cs.food_production.dto.RecipeMaterialDto;
import ku.cs.food_production.entity.Recipe;
import ku.cs.food_production.entity.RecipeItem;
import ku.cs.food_production.repository.RecipeItemRepo;
import ku.cs.food_production.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private RecipeRepo repo;
    private RecipeItemRepo itemRepo;
    private MaterialService materialService;

    @Autowired
    public RecipeService(RecipeRepo repo, RecipeItemRepo itemRepo, MaterialService materialService) {
        this.repo = repo;
        this.itemRepo = itemRepo;
        this.materialService = materialService;
    }


    public Recipe add(List<RecipeMaterialDto> materials, int productId) {
        Recipe recipe = new Recipe();
        for (RecipeMaterialDto materialDto : materials) {
            RecipeItem item = new RecipeItem();
            item.setMaterial(materialService.getById(materialDto.getMaterialId()));
            item.setQty(materialDto.getQty());
            recipe.getItems().add(itemRepo.save(item));
        }
        return repo.save(recipe);
    }

    public List<RecipeMaterialDto> getRecipe(int productId) {
        List<RecipeMaterialDto> result = new ArrayList<>();
        for (RecipeItem item : itemRepo.findAll()) {
            RecipeMaterialDto dto = new RecipeMaterialDto();
            dto.setId(item.getId());
            dto.setQty(item.getQty());
            dto.setDescription(item.getMaterial().getDescription());
            dto.setMaterialId(item.getMaterial().getId());
            dto.setMaterialName(item.getMaterial().getName());
            dto.setUnit(item.getMaterial().getUnit());
            result.add(dto);
        }
        return result;
    }
}
