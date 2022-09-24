package com.restaurant.Services.Administration.Users.impl;

import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Mappers.Administration.Users.UserMapper;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdministrationUserServiceImpl implements AdministrationUserService {

    private final UserMapper mapper
            = Mappers.getMapper(UserMapper.class);
    @Autowired
    private UsersDao usersDao;

    @Override
    public List<UserViewDto> getUsers ( ) {
        return  mapper.modelsToDtoViews((List<User>) usersDao.findAll());
    }

    @Override
    public UserViewDto getUser(Integer id) {
        return mapper.modelToDtoView(usersDao.findById(id).orElse(null));
    }

    @Override
    public UserViewDto getUser() {
        return mapper.modelToDtoView(new User());
    }


}
