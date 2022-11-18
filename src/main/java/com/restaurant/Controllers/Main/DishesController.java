package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Main.DishDto;
import com.restaurant.Models.User;
import com.restaurant.Services.Main.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/dishes")
public class DishesController {

    @Autowired
    private DishService dishService;

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DishDto>> getDishes(@PathVariable Integer type, @AuthenticationPrincipal User user){
        return new ResponseEntity<> (dishService.getDishByType (type), HttpStatus.OK);
    }

}
