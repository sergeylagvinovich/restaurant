package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Dto.Auth.UserLogInDto;
import com.restaurant.Dto.Auth.UserSingUpDto;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdministrationUserService administrationUserService;

    @PostMapping("/register")
    public ResponseEntity<List<UserRolesDto>> registration( @RequestBody UserSingUpDto user){
        return new ResponseEntity<> (administrationUserService.registerUser (user), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLogInDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @GetMapping
    public String test(){
        return "qweqw";
    }
}
