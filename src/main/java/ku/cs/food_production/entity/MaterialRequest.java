package ku.cs.food_production.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MaterialRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String requestNumber;

    private LocalDateTime requestDate;
    private AllocationStatus allocationStatus;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_req_id")
    private List<MaterialRequestItem> materialRequestItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public AllocationStatus getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(AllocationStatus allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public List<MaterialRequestItem> getMaterialRequestItems() {
        return materialRequestItems;
    }

    public void setMaterialRequestItems(List<MaterialRequestItem> materialRequestItems) {
        this.materialRequestItems = materialRequestItems;
    }
}
