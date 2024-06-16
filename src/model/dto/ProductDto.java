package model.dto;

import java.util.Date;

public record ProductDto(
        String productName,
        String productCode,
        boolean isDeleted,
        Date importedDate,
        Date expiredDate,
        String produceDescription
) {
}
