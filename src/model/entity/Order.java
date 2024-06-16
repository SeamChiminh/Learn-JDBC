package model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Integer id;
    private String orderName;
    private String orderDescription;
    private Customer customer;
    private List<Product> productList;
    private Date orderedAt;
}
