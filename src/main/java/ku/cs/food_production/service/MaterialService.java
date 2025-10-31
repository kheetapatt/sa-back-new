package ku.cs.food_production.service;

import ku.cs.food_production.dto.MaterialRecordDto;
import ku.cs.food_production.entity.Material;
import ku.cs.food_production.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {
    private MaterialRepo repo;

    @Autowired
    public MaterialService(MaterialRepo repo) {
        this.repo = repo;
    }

    public List<Material> getAll() {
        return repo.findAll();
    }

    public Material getById(int id) {
        return repo.findById(id).get();
    }

    public Material add(MaterialRecordDto record) {
        Material material = new Material();
        LocalDate now = LocalDate.now();
        String code = null;
        if (getLastCreatedAt(now) != null) code = getLastCreatedAt(now).getCode();
        MaterialCodeGen gen = new MaterialCodeGen(now, code);
        material.setCode(gen.getCode());
        material.setName(record.getName());
        material.setUnit(record.getUnit());
        material.setDescription(record.getDescription());
        material.setCreatedAt(now);
        return repo.save(material);
    }

    public Material update(MaterialRecordDto record, int id) {
        Material material = repo.findById(id).get();
        material.setCode("MaterialCodeGen");
        material.setName(record.getName());
        material.setUnit(record.getUnit());
        material.setDescription(record.getDescription());
        return repo.save(material);
    }

    public Material delete(int id) {
        Material material = repo.findById(id).get();
        repo.delete(material);
        return material;
    }

    public Material getByCode(String code) {
        return repo.findByCode(code);
    }

    public Material getLastCreatedAt(LocalDate createdAt) {
        List<Material> materials = repo.findAllByCreatedAt(createdAt);
        List<Material> sortedMaterials = materials.stream()
                .sorted(Comparator.comparing(Material::getCode).reversed())
                .collect(Collectors.toList());
        if (sortedMaterials.size() > 0) {
            return sortedMaterials.get(0);
        }
        return null;
    }
}
