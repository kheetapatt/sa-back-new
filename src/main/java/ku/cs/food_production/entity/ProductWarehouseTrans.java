package ku.cs.food_production.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductWarehouseTrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_lot_id", nullable = false)
    private ProductLot productLot;

    private int qty;
    private TransType transType;
    private TransRefType refType;
    private int refId;
    private LocalDateTime transDate;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductLot getProductLot() {
        return productLot;
    }

    public void setProductLot(ProductLot productLot) {
        this.productLot = productLot;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public TransRefType getRefType() {
        return refType;
    }

    public void setRefType(TransRefType refType) {
        this.refType = refType;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public LocalDateTime getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDateTime transDate) {
        this.transDate = transDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
