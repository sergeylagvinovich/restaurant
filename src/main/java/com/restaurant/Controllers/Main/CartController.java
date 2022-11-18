package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Main.CartPage;
import com.restaurant.Models.Dish;
import com.restaurant.Models.Order;
import com.restaurant.Services.Main.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/carts")
public class CartController {

    @Autowired
    private CardService cardService;

    @PostMapping("{dish}")
    public ResponseEntity<Boolean> addToCard(@PathVariable Dish dish){
        cardService.addToCard(dish);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CartPage> getCart(){
        return new ResponseEntity<>(cardService.getCart(), HttpStatus.OK);
    }

}
