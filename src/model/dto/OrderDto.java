package model.dto;

import model.entity.Customer;

import java.util.Date;

public record OrderDto(
        String orderName,
        String orderDescription,
        Customer customer,
        Date orderAt
) {
}
