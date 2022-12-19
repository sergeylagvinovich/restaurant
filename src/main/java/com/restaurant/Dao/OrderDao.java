package com.restaurant.Dao;

import com.restaurant.Models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<Order,Integer> {

    List<Order> findOrderByExecutorIdOrderById(Integer id);
    List<Order> findOrderByOrderStatusPriorityOrderById(Integer priority);
    List<Order> findOrderByExecutorIsNullOrderById();


    List<Order> findOrderByUserIdAndOrderStatusId(Integer userId, Integer statusId);
    List<Order> findOrderByUserIdAndOrderStatusIdIsLessThan(Integer userId, Integer statusId);
}
