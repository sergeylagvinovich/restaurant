package com.restaurant.Dto.Main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDishesDto {

    Integer id;
    Integer cartId;
    Integer dishId;
    String imgPath;
    Float price;
    Integer count;
    String name;

}
