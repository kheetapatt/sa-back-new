package ku.cs.food_production.service;

import ku.cs.food_production.repository.MaterialShortageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialShortageService {
    private MaterialShortageRepo repo;

    @Autowired
    public MaterialShortageService(MaterialShortageRepo repo) {
        this.repo = repo;
    }
}
