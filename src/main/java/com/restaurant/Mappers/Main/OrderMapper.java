package com.restaurant.Mappers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {CartMapper.class})
public interface OrderMapper {

    @Mapping(target = "card.id", source = "cartId")
    @Mapping(target = "orderStatus.id", source = "orderStatus")
    Order createOrderDtoToModel(CreateOrderDto createOrderDto);

}
