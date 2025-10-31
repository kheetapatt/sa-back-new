package ku.cs.food_production.service;

import ku.cs.food_production.entity.Product;
import ku.cs.food_production.entity.ProductLot;
import ku.cs.food_production.entity.ProductionOrder;
import ku.cs.food_production.repository.ProductLotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductLotService {
    private ProductLotRepo repo;

    @Autowired
    public ProductLotService(ProductLotRepo repo) {
        this.repo = repo;
    }

    public ProductLot getLastCreatedAt(LocalDateTime createdAt, Product product) {
        List<ProductLot> pos = repo.findAllByCreatedAt(createdAt);
        List<ProductLot> pos1 = pos.stream()
                .filter(lot -> lot.getProduct().getId() == product.getId())
                .collect(Collectors.toList());
        List<ProductLot> sortedProductLots = pos1.stream()
                .sorted(Comparator.comparing(ProductLot::getLotNumber).reversed())
                .collect(Collectors.toList());
        return sortedProductLots.get(0);
    }
}
