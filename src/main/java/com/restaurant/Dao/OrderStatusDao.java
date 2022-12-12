package com.restaurant.Dao;

import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderStatusDao extends CrudRepository<OrderStatus,Integer> {

}
