package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.DishDao;
import com.restaurant.Dto.Main.DishDto;
import com.restaurant.Mappers.Main.DishMapper;
import com.restaurant.Models.Dish;
import com.restaurant.Services.Main.DishService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DishServiceImpl implements DishService {

    @Autowired
    private DishDao dishDao;

    private final DishMapper mapper
            = Mappers.getMapper(DishMapper.class);

    @Override
    public List<DishDto> getDishByType ( Integer type ) {
        List<Dish> dishes = type!=0?dishDao.findAllByDishTypeId (type):(List<Dish>)dishDao.findAll ();
        return mapper.modelsToDtos (dishes);
    }
}
