package ku.cs.food_production.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MaterialShortage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime recordDate;
    private String notes;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_short_id")
    private List<MaterialShortageItem> materialShortageItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<MaterialShortageItem> getMaterialShortageItems() {
        return materialShortageItems;
    }

    public void setMaterialShortageItems(List<MaterialShortageItem> materialShortageItems) {
        this.materialShortageItems = materialShortageItems;
    }
}
