package ku.cs.food_production.entity;

public enum AllocationStatus {
    ALLOCATED("จัดสรรแล้ว"),
    NOT_ALLOCATED("ยังไม่จัดสรร");
    private String description;

    private AllocationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
