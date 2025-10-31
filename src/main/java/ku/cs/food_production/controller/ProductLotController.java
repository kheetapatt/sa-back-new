package ku.cs.food_production.controller;

import ku.cs.food_production.service.ProductLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductLotController {
    private ProductLotService service;

    @Autowired
    public ProductLotController(ProductLotService service) {
        this.service = service;
    }
}
