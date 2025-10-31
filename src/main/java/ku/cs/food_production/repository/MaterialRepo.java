package ku.cs.food_production.repository;

import ku.cs.food_production.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Integer> {
    Material findByCode(String code);

    List<Material> findAllByCreatedAt(LocalDate createdAt);
}
