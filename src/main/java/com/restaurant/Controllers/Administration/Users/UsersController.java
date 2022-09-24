package com.restaurant.Controllers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/users")
public class UsersController {


    @Autowired
    private final AdministrationUserService administrationUserService;

    public UsersController(AdministrationUserService administrationUserService) {
        this.administrationUserService = administrationUserService;
    }

    @GetMapping
    public ResponseEntity<List<UserViewDto>> index(){
        return new ResponseEntity<>(administrationUserService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<UserViewDto> create(){
        return new ResponseEntity<>(administrationUserService.getUser(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> store(@RequestBody UserViewDto userViewDto ){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDto> show(@PathVariable Integer id ){
        return new ResponseEntity<>(administrationUserService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/edit")
    public User edit( @PathVariable String id ){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update( @RequestBody UserViewDto userViewDto ){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete( @PathVariable String id ){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }
}
