package ku.cs.food_production.service;

import ku.cs.food_production.dto.ProductRecordDto;
import ku.cs.food_production.entity.Product;
import ku.cs.food_production.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepo repo;

    @Autowired
    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product add(ProductRecordDto record) {
        Product product = new Product();
        LocalDate now = LocalDate.now();
        String code = null;
        if (getLastCreatedAt(now) != null) code = getLastCreatedAt(now).getCode();
        ProductCodeGen gen = new ProductCodeGen(now, code);
        product.setCode(gen.getCode());
        product.setName(record.getName());
        product.setUnit(record.getUnit());
        product.setDescription(record.getDescription());
        product.setCreatedAt(now);
        return repo.save(product);
    }

    public Product update(ProductRecordDto record, int id) {
        Product product = repo.findById(id).get();
        product.setName(record.getName());
        product.setUnit(record.getUnit());
        product.setDescription(record.getDescription());
        return repo.save(product);
    }

    public Product delete(int id) {
        Product product = repo.findById(id).get();
        repo.delete(product);
        return product;
    }

    public Product getLastCreatedAt(LocalDate createdAt) {
        List<Product> products = repo.findAllByCreatedAt(createdAt);
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getCode).reversed())
                .collect(Collectors.toList());
        if (sortedProducts.size() > 0) {
            return sortedProducts.get(0);
        }
        return null;
    }
}
