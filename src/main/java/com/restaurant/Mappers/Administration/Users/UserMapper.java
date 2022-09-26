package com.restaurant.Mappers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Mappers.Administration.Roles.RoleMapper;
import com.restaurant.Models.Role;
import com.restaurant.Models.User;
import com.restaurant.Models.UserRoles;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(uses = {UserRolesMapper.class, RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "userRoles", source = "roles")
    UserViewDto modelToDtoView(User user);

    List<UserViewDto> modelsToDtoViews(List<User> users);

    @Mapping(target = "userRoles", source = "roles")
    UserEditDto modelToDtoEdit(User user);


    @Mapping(target = "roles", source = "userRoles")
    User userDtoEditToModel(UserEditDto userEditDto);

    @AfterMapping
    default void linkUser( @MappingTarget User user){
        user.getRoles ().stream ().forEach (x->x.setUser (user));
    }




}
