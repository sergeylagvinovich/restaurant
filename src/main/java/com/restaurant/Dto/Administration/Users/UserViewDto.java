package com.restaurant.Dto.Administration.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewDto {

    private Integer id;
    private String userName;
    private String email;
    private String phone;
    private String name;
    private Boolean isActive;
}
