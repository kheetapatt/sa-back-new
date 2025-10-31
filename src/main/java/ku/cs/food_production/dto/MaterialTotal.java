package ku.cs.food_production.dto;

public class MaterialTotal {
    private int materialId;
    private String code;
    private String name;
    private double totalQty;
    private int totalLotQty;

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(double totalQty) {
        this.totalQty = totalQty;
    }

    public int getTotalLotQty() {
        return totalLotQty;
    }

    public void setTotalLotQty(int totalLotQty) {
        this.totalLotQty = totalLotQty;
    }
}
