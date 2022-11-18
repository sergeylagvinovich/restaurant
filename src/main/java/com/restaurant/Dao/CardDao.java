package com.restaurant.Dao;

import com.restaurant.Models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card,Integer> {

    Card findByUser_IdAndInOrder(Integer user_id, boolean inOrder);

}
