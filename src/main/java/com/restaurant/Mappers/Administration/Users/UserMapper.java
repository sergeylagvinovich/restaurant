package com.restaurant.Mappers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserViewDto modelToDtoView(User user);

    List<UserViewDto> modelsToDtoViews(List<User> users);

}
