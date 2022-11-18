package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Services.Main.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> addToOrder(@RequestBody CreateOrderDto createOrderDto){
        orderService.createOrder(createOrderDto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
