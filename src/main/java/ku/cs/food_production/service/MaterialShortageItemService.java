package ku.cs.food_production.service;

import ku.cs.food_production.repository.MaterialShortageItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialShortageItemService {
    private MaterialShortageItemRepo repo;

    @Autowired
    public MaterialShortageItemService(MaterialShortageItemRepo repo) {
        this.repo = repo;
    }
}
