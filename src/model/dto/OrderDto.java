package model.dto;

import lombok.Builder;
import model.entity.Customer;

import java.sql.Date;


@Builder
public record OrderDto(
        String orderName,
        String orderDescription,
        Customer customer,
        Date orderAt
) {
}
