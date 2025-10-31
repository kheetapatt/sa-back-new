package ku.cs.food_production.service;

import ku.cs.food_production.repository.ProductWarehouseTransRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductWarehouseTransService {
    private ProductWarehouseTransRepo repo;

    @Autowired
    public ProductWarehouseTransService(ProductWarehouseTransRepo repo) {
        this.repo = repo;
    }
}
