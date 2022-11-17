package com.restaurant.Services.Administration.Users;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Dto.Auth.UserSingUpDto;

import java.util.List;

public interface AdministrationUserService {

    List<UserViewDto> getUsersForTable();
    UserViewDto getUserForView(Integer id);
    UserEditDto getUserForEdit(Integer id);
    UserEditDto saveUser(UserEditDto user);
    Boolean deleteUser(Integer id);

    List<UserRolesDto> registerUser( UserSingUpDto userSingUpDto);

}
