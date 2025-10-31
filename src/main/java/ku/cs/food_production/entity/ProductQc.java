package ku.cs.food_production.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductQc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_lot_id", nullable = false)
    private ProductLot productLot;

    private boolean isPass;
    private LocalDateTime qcDate;
    private int qtyTest;

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

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public LocalDateTime getQcDate() {
        return qcDate;
    }

    public void setQcDate(LocalDateTime qcDate) {
        this.qcDate = qcDate;
    }

    public int getQtyTest() {
        return qtyTest;
    }

    public void setQtyTest(int qtyTest) {
        this.qtyTest = qtyTest;
    }
}
