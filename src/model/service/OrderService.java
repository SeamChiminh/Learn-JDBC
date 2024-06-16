package model.service;

import model.dao.OrderDao;
import model.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryAllOrder();
    int updateOrderById(Integer id);
    int deleteOrderById(Integer id);
    void addNewOrder(OrderDao orderDao);
    OrderDao searchOderById(Integer id);

}
