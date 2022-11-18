package com.restaurant.Mappers.Main;

import com.restaurant.Dto.Main.CartDishesDto;
import com.restaurant.Models.CardDishes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface CartDishesMapper {

    @Mapping(target = "imgPath", source = "dish.imgPath")
    @Mapping(target = "price", source = "dish.price")
    @Mapping(target = "name", source = "dish.name")
    @Mapping(target = "cartId", source = "card.id")
    @Mapping(target = "dishId", source = "dish.id")
    CartDishesDto modelToDto(CardDishes cardDishes);

    Set<CartDishesDto> modelToDto(Set<CardDishes> cardDishes);

    @Mapping(target = "card.id", source = "cartId")
    @Mapping(target = "dish.id", source = "dishId")
    CardDishes dtoToModel(CartDishesDto cartDishesDto);

    Set<CardDishes> dtosToModel(Set<CartDishesDto> cartDishesDtos);

}
