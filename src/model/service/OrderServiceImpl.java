package model.service;

import mapper.Mapper;
import model.dao.OrderDao;
import model.dao.OrderDaoImpl;
import model.dto.OrderDto;
import model.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<OrderDto> queryAllOrder() {
        return orderDao.queryAllOrders()
                .stream()
                .map(Mapper::formOrderToOrderDto)
                .toList();
    }

    @Override
    public int updateOrderById(Integer id) {
        Order existingOrder = orderDao.searchOrderById(id);
        if (existingOrder != null) {
            existingOrder.setOrderDescription("Updated Description");
            orderDao.updateOrderById(existingOrder.getId());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOrderById(Integer id) {
        Order existingOrder = orderDao.searchOrderById(id);
        if (existingOrder != null) {
            orderDao.deleteOrderById(existingOrder.getId());
            return 1;
        }
        return 0;
    }

    @Override
    public void addNewOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .orderName(orderDto.orderName())
                .orderDescription(orderDto.orderDescription())
                .orderedAt(orderDto.orderAt())
                .id(orderDto.customer().getId())
                .build();
    }

    @Override
    public OrderDto searchOderById(Integer id) {
        Order order = orderDao.searchOrderById(id);
        if(order != null)
        {
            OrderDto orderDto = Mapper.formOrderToOrderDto(order);
            System.out.println("Order Name: " + orderDto.orderName());
            System.out.println("Order Description: " + orderDto.orderDescription());
            System.out.println("Customer ID: " + orderDto.customer().getId());
            System.out.println("Order At: " + orderDto.orderAt());
            return orderDto;
        }else {
            System.out.println("Order Not Found");
            return null;
        }
    }
}
