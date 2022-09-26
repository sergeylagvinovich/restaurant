package com.restaurant.Mappers.Administration.Roles;


import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleDto modelToDto(Role role);
    List<RoleDto> modelsToDtos(List<Role> roles);

    Role dtoToModel(RoleDto role);
}
