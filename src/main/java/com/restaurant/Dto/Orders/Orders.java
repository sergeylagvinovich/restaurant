package com.restaurant.Dto.Orders;

import com.restaurant.Dto.Main.CartDishesDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Orders {

    Integer orderId;
    Integer orderStatus;
    Set<CartDishesDto> dishes;

}
