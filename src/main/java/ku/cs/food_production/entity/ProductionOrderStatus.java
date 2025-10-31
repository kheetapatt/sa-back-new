package ku.cs.food_production.entity;

public enum ProductionOrderStatus {
    WAIT_FOR_ALLOCATION("รอจัดสรรวัตถุดิบ"),
    WAIT_FOR_PRODUCTION("รอผลิต"),
    IN_PROGRESS("กำลังผลิต"),
    PARTIAL_COMPLETION("เสร็จสิ้นบางส่วน"),
    COMPLETED("เสร็จสิ้น"),
    CANCELLED("ยกเลิก"),
    CLOSED("จบ");
    private String description;

    private ProductionOrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
