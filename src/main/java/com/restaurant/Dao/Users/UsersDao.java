package com.restaurant.Dao.Users;

import com.restaurant.Models.User;
import org.springframework.data.repository.CrudRepository;



public interface UsersDao extends CrudRepository<User,Integer> {

}
