package com.restaurant.Services.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;

import java.io.IOException;

public interface OrderService {

    Boolean createOrder(CreateOrderDto createOrderDto) throws IOException;

    OrdersPageDto getOrders(Integer priority);

    boolean setStatus(Integer status, Order order) throws IOException;
}
