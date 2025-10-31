package ku.cs.food_production.service;

import ku.cs.food_production.dto.MaterialLotRecordDto;
import ku.cs.food_production.dto.MaterialTotal;
import ku.cs.food_production.entity.Material;
import ku.cs.food_production.entity.MaterialLot;
import ku.cs.food_production.entity.Product;
import ku.cs.food_production.entity.ProductLot;
import ku.cs.food_production.repository.MaterialLotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialLotService {
    private MaterialLotRepo repo;
    private MaterialService materialService;

    @Autowired
    public MaterialLotService(MaterialLotRepo repo, MaterialService materialService) {
        this.repo = repo;
        this.materialService = materialService;
    }

    public List<MaterialLot> getAll() {
        return repo.findAll();
    }

    public List<MaterialTotal> getMaterialTotals() {
        List<Material> materials = materialService.getAll();
        List<MaterialTotal> totals = new ArrayList<>();
        for (Material material : materials) {
            List<MaterialLot> materialLots = repo.findAllByMaterial(material);
            MaterialTotal total = new MaterialTotal();
            total.setCode(material.getCode());
            total.setName(material.getName());
            total.setTotalLotQty(materialLots.size());
            double totalQty = 0;
            for (MaterialLot m : materialLots) {
                totalQty += m.getQty();
            }
            total.setTotalQty(totalQty);
        }
        return totals;
    }

    public List<MaterialLot> getAllByMaterialId(int materialId) {
        return repo.findAllByMaterial(materialService.getById(materialId));
    }

    public List<MaterialLot> getNotStoredMaterialLots() {
        return getAll().stream()
                .filter(lot -> !lot.isStore())
                .collect(Collectors.toList());
    }

    public MaterialLot add(MaterialLotRecordDto record) {
        MaterialLot materialLot = new MaterialLot();
        materialLot.setLotNumber(""); //
        materialLot.setMaterial(materialService.getByCode(record.getMaterialCode()));
        materialLot.setQty(record.getQty());
        materialLot.setImportDate(LocalDateTime.parse(record.getImportDate())); //
        materialLot.setExpirationDate(LocalDateTime.parse(record.getExpirationDate()));
        materialLot.setStore(false);
        materialLot.setCreatedAt(LocalDate.now());
        return repo.save(materialLot);
    }

    public MaterialLot getLastCreatedAt(LocalDateTime createdAt, Material material) {
        List<MaterialLot> pos = repo.findAllByCreatedAt(createdAt);
        List<MaterialLot> pos1 = pos.stream()
                .filter(lot -> lot.getMaterial().getId() == material.getId())
                .collect(Collectors.toList());
        List<MaterialLot> sortedMaterialLots = pos1.stream()
                .sorted(Comparator.comparing(MaterialLot::getLotNumber).reversed())
                .collect(Collectors.toList());
        return sortedMaterialLots.get(0);
    }
}
