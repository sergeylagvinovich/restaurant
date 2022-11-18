package com.restaurant.Dao;

import com.restaurant.Models.CardDishes;
import org.springframework.data.repository.CrudRepository;

public interface CardDishesDao extends CrudRepository<CardDishes, Integer> {
}
