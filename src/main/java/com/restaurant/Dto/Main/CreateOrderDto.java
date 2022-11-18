package com.restaurant.Dto.Main;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateOrderDto {

    Integer id = null;
    Integer cartId;
    Set<CartDishesDto> cartDishes;
    String address;
    String phone;
    Integer orderStatus = 1;


}
