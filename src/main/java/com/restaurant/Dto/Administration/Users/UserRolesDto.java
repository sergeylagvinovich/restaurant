package com.restaurant.Dto.Administration.Users;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRolesDto {

    private Integer id;
    private RoleDto role;
    private Boolean canInsert;
    private Boolean canUpdate;
    private Boolean canDelete;
    private Boolean canView;
}
