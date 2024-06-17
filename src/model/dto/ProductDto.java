package model.dto;

import lombok.Builder;

import java.sql.Date;


@Builder

public record ProductDto(
        String productName,
        String productCode,
        boolean isDeleted,
        Date importedDate,
        Date expiredDate,
        String produceDescription
) {
}
