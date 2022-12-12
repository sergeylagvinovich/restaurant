package com.restaurant.Mappers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.Orders;
import com.restaurant.Models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {CartMapper.class, CartDishesMapper.class})
public interface OrderMapper {

    @Mapping(target = "card.id", source = "cartId")
    @Mapping(target = "orderStatus.id", source = "orderStatus")
    Order createOrderDtoToModel(CreateOrderDto createOrderDto);


    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "orderStatus", source = "orderStatus.priority")
    @Mapping(target = "dishes", source = "card.dishes")
    Orders ordersToPageOrder(Order order);

    List<Orders> ordersToPageOrderList(List<Order> orders);

}
