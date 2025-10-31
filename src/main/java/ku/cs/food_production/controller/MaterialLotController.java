package ku.cs.food_production.controller;

import ku.cs.food_production.dto.MaterialLotRecordDto;
import ku.cs.food_production.dto.MaterialTotal;
import ku.cs.food_production.entity.MaterialLot;
import ku.cs.food_production.service.MaterialLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialLotController {
    private MaterialLotService service;

    @Autowired
    public MaterialLotController(MaterialLotService service) {
        this.service = service;
    }

    @GetMapping("/material/total")
    public List<MaterialTotal> getMaterialTotals() {
        return service.getMaterialTotals();
    }

    @GetMapping("/material_lot/{materialId}")
    public List<MaterialLot> getAllByMaterialId(int materialId) {
        return service.getAllByMaterialId(materialId);
    }

    @GetMapping("/material_lot/not_stored")
    public List<MaterialLot> getNotStoredMaterialLots() {
        return service.getNotStoredMaterialLots();
    }

    public MaterialLot add(MaterialLotRecordDto record) {
        return service.add(record);
    }
}
