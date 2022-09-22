package com.restaurant.Services.Administration.Users.impl;

import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdministrationUserServiceImpl implements AdministrationUserService {

    @Autowired
    private UsersDao usersDao;
    @Override
    public List<User> getUsers ( ) {
        return (List<User>) usersDao.findAll();
    }
}
