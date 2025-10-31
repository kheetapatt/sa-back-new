package ku.cs.food_production.entity;

public enum TransType {
    IN("เข้า"),
    OUT("ออก");
    private String description;

    private TransType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
