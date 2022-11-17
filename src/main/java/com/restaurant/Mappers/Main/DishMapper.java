package com.restaurant.Mappers.Main;


import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Main.DishDto;
import com.restaurant.Mappers.Administration.Roles.RoleMapper;
import com.restaurant.Mappers.Administration.Users.UserRolesMapper;
import com.restaurant.Models.Dish;
import com.restaurant.Models.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {DishProductsMapper.class})
public interface DishMapper {


    DishDto modelToDto( Dish dish);
    List<DishDto> modelsToDtos(List<Dish> dishes);
}
