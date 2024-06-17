package controller;

import model.dto.OrderDto;
import model.service.OrderService;
import model.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderService orderService = new OrderServiceImpl();
    public void AddNewOrder(OrderDto orderDto) {
        orderService.addNewOrder(orderDto);
    }

    public List<OrderDto> queryAllOrders() {
        return orderService.queryAllOrder();
    }

    public void searchOrderById(Integer id) {
        orderService.searchOderById(id);
    }

    public void deleteOrderById(Integer id) {
        orderService.deleteOrderById(id);
    }

    public void updateOrderById(Integer id) {
        orderService.updateOrderById(id);
    }
}
