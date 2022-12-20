package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;
import com.restaurant.Services.Main.OrderService;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> addToOrder(@RequestBody CreateOrderDto createOrderDto) throws IOException {
        orderService.createOrder(createOrderDto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{priority}")
    public ResponseEntity<OrdersPageDto> getOrder(@PathVariable Integer priority){
        return new ResponseEntity<>(orderService.getOrders(priority),HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<OrdersPageDto> getOrderUser(){
        return new ResponseEntity<>(orderService.getOrdersUser (),HttpStatus.OK);
    }

    @PostMapping("/{order}/{status}/{priority}")
    public ResponseEntity<OrdersPageDto> setStatus(@PathVariable Order order, @PathVariable Integer status, @PathVariable Integer priority) throws IOException {
        orderService.setStatus(status, order);
        return new ResponseEntity<>(orderService.getOrders(priority), HttpStatus.OK);
    }


    @Value("${path.to.save.order}")
    String fileBasePath;

    @GetMapping("/download/{fileName}")
    public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
        Path path = Paths.get(fileBasePath + fileName+".docx");
        Resource resource = null;
        try {
            resource = new UrlResource (path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert resource != null;
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



}
