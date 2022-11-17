package com.restaurant.Services.Administration.Roles;

import com.restaurant.Dto.Administration.Roles.RoleDto;

import java.util.List;

public interface AdministrationRoleService {

    List<RoleDto> getRoles();
    RoleDto getRoleForView(Integer id);
    RoleDto getRoleForEdit(Integer id);
    RoleDto saveRole(RoleDto user);

    Boolean deleteRole(Integer id);

}
