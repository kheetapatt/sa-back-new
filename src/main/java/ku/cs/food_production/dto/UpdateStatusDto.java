package ku.cs.food_production.dto;

public class UpdateStatusDto {
    private int poId;
    private String newStatus;

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
