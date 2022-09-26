package com.restaurant.Mappers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Models.UserRoles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface UserRolesMapper {

    Set<UserRolesDto> modelToUsersRolesDto (Set<UserRoles> roles);
    @Mapping(target = "role", source = "role")
    UserRolesDto modelToUsersRoleDto (UserRoles roles);

    @Mapping(target = "role", source = "role")
    UserRoles dtoToModel (UserRolesDto roles);


}
