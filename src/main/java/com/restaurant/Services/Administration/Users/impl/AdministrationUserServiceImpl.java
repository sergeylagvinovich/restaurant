package com.restaurant.Services.Administration.Users.impl;

import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Mappers.Administration.Users.UserMapper;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class AdministrationUserServiceImpl implements AdministrationUserService {

    private final UserMapper mapper
            = Mappers.getMapper(UserMapper.class);
    @Autowired
    private UsersDao usersDao;


    @Override
    public List<UserViewDto> getUsersForTable() {
        return mapper.modelsToDtoViews((List<User>) usersDao.findAll());
    }

    @Override
    public UserViewDto getUserForView(Integer id) {
        return mapper.modelToDtoView(usersDao.findById(id).orElse(null));
    }

    @Override
    public UserEditDto getUserForEdit(Integer id) {
        if(id!=null) {
            return mapper.modelToDtoEdit(usersDao.findById(id).orElse(new User()));
        }else{
            return mapper.modelToDtoEdit(new User());
        }
    }

    @Override
    public UserEditDto saveUser(UserEditDto user) {
        User newUser = mapper.userDtoEditToModel(user);
        newUser = usersDao.save(newUser);
        return mapper.modelToDtoEdit(newUser);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        User user = usersDao.findById(id).orElse(null);
        if(user!=null){
            usersDao.delete(user);
        }else{
            return false;
        }
        return true;
    }
}
