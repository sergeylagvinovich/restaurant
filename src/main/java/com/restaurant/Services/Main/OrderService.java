package com.restaurant.Services.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;

public interface OrderService {

    Boolean createOrder(CreateOrderDto createOrderDto);

    OrdersPageDto getOrders(Integer priority);

    boolean setStatus(Integer status, Order order);
}
