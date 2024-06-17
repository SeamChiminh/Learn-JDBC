package mapper;

import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Product;

public class Mapper {
    public  static CustomerDto fromCustomerToCustomerDto(Customer customer){
        if(customer == null){
            return null;
        }
        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .id(customer.getId())
                .build();
    }

    public static ProductDto fromProductToProductDto(Product product){
        if(product == null){
            return null;
        }
        return ProductDto.builder()
                .productName(product.getProductName())
                .productCode(product.getProductCode())
                .isDeleted(product.getIsDeleted())
                .importedDate(product.getImportAt())
                .expiredDate(product.getExpiredAt())
                .produceDescription(product.getProductDescription())
                .build();
    }

    public static OrderDto formOrderToOrderDto(Order order){
        if(order == null){
            return null;
        }
        return OrderDto.builder()
                .orderName(order.getOrderName())
                .orderDescription(order.getOrderDescription())
                .customer(order.getCustomer())
                .orderAt(order.getOrderedAt())
                .build();
    }
}
