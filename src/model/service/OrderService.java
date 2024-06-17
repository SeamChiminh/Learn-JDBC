package model.service;

import model.dao.OrderDao;
import model.dto.OrderDto;
import model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> queryAllOrder();
    int updateOrderById(Integer id);
    int deleteOrderById(Integer id);
    void addNewOrder(OrderDto orderDto);
    OrderDto searchOderById(Integer id);

}
