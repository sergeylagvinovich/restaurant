package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;
import com.restaurant.Services.Main.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{priority}")
    public ResponseEntity<OrdersPageDto> getOrder(@PathVariable Integer priority){
        return new ResponseEntity<>(orderService.getOrders(priority),HttpStatus.OK);
    }

    @PostMapping("/{order}/{status}/{priority}")
    public ResponseEntity<OrdersPageDto> setStatus(@PathVariable Order order, @PathVariable Integer status, @PathVariable Integer priority){
        orderService.setStatus(status, order);
        return new ResponseEntity<>(orderService.getOrders(priority),HttpStatus.OK);
    }



}
