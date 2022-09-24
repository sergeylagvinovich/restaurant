package com.restaurant.Services.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserViewDto;

import java.util.List;

public interface AdministrationUserService {

    List<UserViewDto> getUsers();
    UserViewDto getUser(Integer id);
    UserViewDto getUser();

}
