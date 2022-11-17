package com.restaurant.Mappers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Dto.Auth.UserSingUpDto;
import com.restaurant.Mappers.Administration.Roles.RoleMapper;
import com.restaurant.Models.User;
import org.mapstruct.*;

import java.util.List;

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
        user.getRoles ().forEach (x->x.setUser (user));
    }


    @Mapping(target = "name", source = "userName")
    User userSingUpToModel( UserSingUpDto userSingUpDto );


}
