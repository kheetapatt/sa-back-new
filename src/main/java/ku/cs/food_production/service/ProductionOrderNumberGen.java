package ku.cs.food_production.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductionOrderNumberGen {
    private String productCode;
    private LocalDateTime creationDate;
    private String lastNumber;

    public ProductionOrderNumberGen(String productCode, LocalDateTime creationDate, String lastNumber) {
        this.productCode = productCode;
        this.creationDate = creationDate;
        this.lastNumber = lastNumber;
    }

    public String getProductionOrderNumber() {
        String datePart = creationDate.format(DateTimeFormatter.ofPattern("yyMMdd"));

        int nextSeq = 1;

        if (lastNumber != null) {
            String[] parts = lastNumber.split("-");
            if (parts.length == 5) {
                try {
                    nextSeq = Integer.parseInt(parts[4]) + 1;
                } catch (NumberFormatException e) {
                    nextSeq = 1;
                }
            }
        }

        String seqStr = String.format("%03d", nextSeq);

        return "PO-" + productCode + "-" + datePart + "-" + seqStr;
    }
}
