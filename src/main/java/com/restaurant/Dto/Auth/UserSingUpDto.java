package com.restaurant.Dto.Auth;

import com.restaurant.Dto.Administration.Users.UserRolesDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserSingUpDto {

    private String userName;
    private String email;
    private String password;
    private Boolean isActive = true;
    private Set<UserRolesDto> userRoles = new HashSet<> ();

}
