package com.restaurant.Controllers.Administration.Users;

import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/users/")
public class UsersController {


    @Autowired
    private AdministrationUserService administrationUserService;

    @GetMapping
    public List<User> index(){
        return administrationUserService.getUsers ();
    }

    @GetMapping("/create")
    public User create(){
        return new User ();
    }

    @PostMapping
    public ResponseEntity<String> store(){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public User show( @PathVariable String id ){
        return null;
    }

    @GetMapping("{id}/edit")
    public User edit( @PathVariable String id ){
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update( @PathVariable String id ){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> delete( @PathVariable String id ){
        return new ResponseEntity<>("Your age is ", HttpStatus.OK);
    }
}
