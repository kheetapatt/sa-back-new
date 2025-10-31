package ku.cs.food_production.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductCodeGen {
    private LocalDate createDate;
    private String lastCode;

    public ProductCodeGen(LocalDate createDate, String lastCode) {
        this.createDate = createDate;
        this.lastCode = lastCode;
    }

    public String getCode() {
        String datePart = createDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int nextSequence = 1;

        if (lastCode != null) {
            String[] parts = lastCode.split("-");
            if (parts.length == 3) {
                try {
                    int lastSequence = Integer.parseInt(parts[2]);
                    nextSequence = lastSequence + 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid code format: " + lastCode);
                }
            }
        }

        String formattedSequence = String.format("%03d", nextSequence);

        return "P" + "-" + datePart + "-" + formattedSequence;
    }
}
