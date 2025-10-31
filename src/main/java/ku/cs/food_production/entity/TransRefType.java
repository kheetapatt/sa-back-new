package ku.cs.food_production.entity;

public enum TransRefType {
    STORE_FINISH_PRODUCT("จัดเก็บสินค้าที่ผลิตเสร็จ"),
    TAKE_OUT_PRODUCT("นำออกสินค้า"),
    PRODUCT_RETURN("คืนสินค้าเข้าคลัง"),
    PRODUCT_QC("ตรวจสอบคุณภาพสินค้า"),
    STORE_NEW_MATERIAL("จัดเก็บวัตถุดิบใหม่"),
    MATERIAL_ALLOCATION("จัดสรรวัตถุดิบ"),
    MATERIAL_RETURN("คืนวัตถุดิบเข้าคลัง"),
    MATERIAL_QC("ตรวจสอบคุณภาพวัตถุดิบ");
    private String description;

    private TransRefType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
