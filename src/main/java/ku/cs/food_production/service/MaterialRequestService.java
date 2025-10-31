package ku.cs.food_production.service;

import ku.cs.food_production.entity.*;
import ku.cs.food_production.repository.MaterialRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialRequestService {
    private MaterialRequestRepo repo;
    private RecipeService recipeService;

    @Autowired
    public MaterialRequestService(MaterialRequestRepo repo, RecipeService recipeService) {
        this.repo = repo;
        this.recipeService = recipeService;
    }

    public List<MaterialRequest> getAll() {
        return repo.findAll();
    }

    public MaterialRequest add(MaterialRequest request) {
        return repo.save(request);
    }

    public MaterialRequest calculateMaterialRequest(Recipe recipe, int qtyToProduce) {
        List<RecipeItem> recipeItems = recipe.getItems();
        List<MaterialRequestItem> materialRequestItems = new ArrayList<>();
        for (RecipeItem recipeItem : recipeItems) {
            MaterialRequestItem materialRequestItem = new MaterialRequestItem();
            materialRequestItem.setMaterial(recipeItem.getMaterial());
            materialRequestItem.setQty(recipeItem.getQty() * qtyToProduce);
            materialRequestItems.add(materialRequestItem);
        }
        MaterialRequest materialRequest = new MaterialRequest();
        materialRequest.setMaterialRequestItems(materialRequestItems);
        materialRequest.setRequestDate(LocalDateTime.now());
        materialRequest.setAllocationStatus(AllocationStatus.NOT_ALLOCATED);
        return repo.save(materialRequest);
    }
}
