package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Main.DishDto;
import com.restaurant.Services.Main.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/dishes")
public class DishesController {

    @Autowired
    private DishService dishService;

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DishDto>> getDishes( @PathVariable Integer type ){
        return new ResponseEntity<> (dishService.getDishByType (type), HttpStatus.OK);
    }

}
