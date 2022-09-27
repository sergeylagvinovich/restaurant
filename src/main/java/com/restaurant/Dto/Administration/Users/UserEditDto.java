package com.restaurant.Dto.Administration.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
    private Boolean isActive;
    private Set<UserRolesDto> userRoles;


}
