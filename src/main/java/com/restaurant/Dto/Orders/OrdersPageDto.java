package com.restaurant.Dto.Orders;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrdersPageDto {

    List<Orders> freeOrders;
    List<Orders> myOrders;

}
