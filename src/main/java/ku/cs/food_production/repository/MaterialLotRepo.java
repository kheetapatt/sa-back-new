package ku.cs.food_production.repository;

import ku.cs.food_production.entity.Material;
import ku.cs.food_production.entity.MaterialLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaterialLotRepo extends JpaRepository<MaterialLot, Integer> {
    List<MaterialLot> findAllByMaterial(Material material);
    List<MaterialLot> findAllByCreatedAt(LocalDateTime createdAt);
}
