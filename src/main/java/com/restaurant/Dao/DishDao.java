package com.restaurant.Dao;

import com.restaurant.Models.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishDao extends CrudRepository<Dish,Integer> {

    List<Dish> findAllByDishTypeId(Integer type);
}
