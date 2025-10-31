package ku.cs.food_production.controller;

import ku.cs.food_production.dto.ProductionOrderDto;
import ku.cs.food_production.dto.ProductionOrderRecordDto;
import ku.cs.food_production.dto.UpdateStatusDto;
import ku.cs.food_production.entity.ProductionOrder;
import ku.cs.food_production.service.ProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductionOrderController {
    private ProductionOrderService service;

    @Autowired
    public ProductionOrderController(ProductionOrderService service) {
        this.service = service;
    }

    @GetMapping("/production_orders")
    public List<ProductionOrderDto> getAll() {
        return service.getAll();
    }

    @PostMapping("/production_orders")
    public ProductionOrder add(@RequestBody ProductionOrderRecordDto record) {
        return service.add(record);
    }

    @PutMapping("/production_orders/update_status")
    public ProductionOrder updateStatus(@RequestBody UpdateStatusDto updateStatusDto) {
        return service.updateStatus(updateStatusDto);
    }
}
