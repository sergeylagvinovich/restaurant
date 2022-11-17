package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Dto.Auth.UserSingUpDto;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AdministrationUserService administrationUserService;

    @PostMapping("register")
    public ResponseEntity<List<UserRolesDto>> registration( @RequestBody UserSingUpDto user){
        return new ResponseEntity<> (administrationUserService.registerUser (user), HttpStatus.OK);
    }

    @GetMapping
    public String test(){
        return "qweqw";
    }
}
