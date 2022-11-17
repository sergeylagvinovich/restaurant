package com.restaurant.Dto.Administration.Users;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserEditDto {

    private Integer id;
    private String userName;
    private String email;
    private String phone;
    private String name;
    private String address;
    private Boolean isActive;
    private Set<UserRolesDto> userRoles = new HashSet<> ();


}
