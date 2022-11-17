package com.restaurant.Dto.Auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogInDto {

    private String password;
    private String email;

}
