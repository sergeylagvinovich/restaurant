package com.restaurant.Dao.Roles;

import com.restaurant.Models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleDao extends PagingAndSortingRepository<Role, Integer> {


}
