package ku.cs.food_production.service;

import ku.cs.food_production.repository.ProductQcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQcService {
    private ProductQcRepo repo;

    @Autowired
    public ProductQcService(ProductQcRepo repo) {
        this.repo = repo;
    }
}
