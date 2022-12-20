package com.restaurant.Dto.Administration.Users;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserViewDto {

    private Integer id;
    private String userName;
    private String password;
    private String address;
    private String email;
    private String phone;
    private String name;
    private Boolean isActive;
    private Set<UserRolesDto> userRoles;
}
