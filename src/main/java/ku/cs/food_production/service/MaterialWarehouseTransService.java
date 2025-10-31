package ku.cs.food_production.service;

import ku.cs.food_production.repository.MaterialWarehouseTransRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialWarehouseTransService {
    private MaterialWarehouseTransRepo repo;

    @Autowired
    public MaterialWarehouseTransService(MaterialWarehouseTransRepo repo) {
        this.repo = repo;
    }
}
