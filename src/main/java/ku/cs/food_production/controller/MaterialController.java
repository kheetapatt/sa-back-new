package ku.cs.food_production.controller;

import ku.cs.food_production.dto.MaterialRecordDto;
import ku.cs.food_production.entity.Material;
import ku.cs.food_production.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialController {
    private MaterialService service;

    @Autowired
    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping("/materials")
    public List<Material> getAll() {
        return service.getAll();
    }

    @PostMapping("/materials")
    public Material add(@RequestBody MaterialRecordDto record) {
        return service.add(record);
    }

    @PutMapping("/materials/update/{id}")
    public Material update(@RequestBody MaterialRecordDto record, @PathVariable int id) {
        return service.update(record, id);
    }

    @DeleteMapping("/materials/{id}")
    public Material delete(@PathVariable int id) {
        return service.delete(id);
    }


}
