package ku.cs.food_production.service;

import ku.cs.food_production.repository.MaterialRequestItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialRequestItemService {
    private MaterialRequestItemRepo repo;

    @Autowired
    public MaterialRequestItemService(MaterialRequestItemRepo repo) {
        this.repo = repo;
    }
}
