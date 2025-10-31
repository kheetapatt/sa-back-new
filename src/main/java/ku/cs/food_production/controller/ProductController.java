package ku.cs.food_production.controller;

import ku.cs.food_production.dto.ProductRecordDto;
import ku.cs.food_production.entity.Product;
import ku.cs.food_production.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping("/products")
    public Product add(@RequestBody ProductRecordDto record) {
        return service.add(record);
    }

    @PutMapping("/products/{id}")
    public Product update(@RequestBody ProductRecordDto record, @PathVariable int id) {
        return service.update(record, id);
    }

    @DeleteMapping("/products/{id}")
    public Product delete(@PathVariable int id) {
        return service.delete(id);
    }
}
