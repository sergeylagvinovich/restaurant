package com.restaurant.Controllers.Administration.Users;

import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Models.User;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/admin/users")
public class UsersController {


    @Autowired
    private final AdministrationUserService administrationUserService;

    public UsersController(AdministrationUserService administrationUserService) {
        this.administrationUserService = administrationUserService;
    }

    @GetMapping
    public ResponseEntity<List<UserViewDto>> index(){
        return new ResponseEntity<>(administrationUserService.getUsersForTable(),HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<UserEditDto> create(){
        return new ResponseEntity<>(administrationUserService.getUserForEdit(null),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEditDto> store(@RequestBody UserEditDto userEditDto ){
        userEditDto = administrationUserService.saveUser(userEditDto);
        return new ResponseEntity<>(userEditDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDto> show(@PathVariable Integer id ){
        return new ResponseEntity<>(administrationUserService.getUserForView(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/edit")
    public ResponseEntity<UserEditDto> edit(@PathVariable Integer id ){
        return new ResponseEntity<>(administrationUserService.getUserForEdit(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEditDto> update( @RequestBody UserEditDto userEditDto ){
        userEditDto = administrationUserService.saveUser(userEditDto);
        return new ResponseEntity<>(userEditDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable Integer id ){
        String result = "Ошибка удаления";
        if(administrationUserService.deleteUser(id)){
            result = "Удаление прошло успешно";
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
