package com.restaurant.Dto.Main;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class CartDto {

    Integer id;
    Set<CartDishesDto> cartDishes;

}
