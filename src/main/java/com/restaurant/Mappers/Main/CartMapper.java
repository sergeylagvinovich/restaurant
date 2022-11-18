package com.restaurant.Mappers.Main;

import com.restaurant.Dto.Main.CartDto;
import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {CartDishesMapper.class})
public interface CartMapper {

    @Mapping(target = "cartDishes", source = "dishes")
    CartDto modelToDto(Card card);


    @Mapping(target = "dishes", source = "cartDishes")
    @Mapping(target = "id", source = "cartId")
    Card dtoToModel(CreateOrderDto cartDto);

}
