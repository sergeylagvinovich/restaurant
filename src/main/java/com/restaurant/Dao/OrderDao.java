package com.restaurant.Dao;

import com.restaurant.Models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order,Integer> {
}
