package ku.cs.food_production.service;

import ku.cs.food_production.repository.MaterialQcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialQcService {
    private MaterialQcRepo repo;

    @Autowired
    public MaterialQcService(MaterialQcRepo repo) {
        this.repo = repo;
    }
}
