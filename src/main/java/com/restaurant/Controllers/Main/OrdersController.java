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
    @GetMapping
    public String tets() throws IOException {
//        XWPFDocument document = new XWPFDocument ();
//        HelpFacade.createDocument (null);
//        File original = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\templates\\templateOrder.docx");
//        File newFile = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\orderTest.docx");
//        FileUtil.copyFile(original,newFile);
//        XWPFDocument document = new XWPFDocument (new FileInputStream (newFile));
//
//        FileOutputStream out = new FileOutputStream (newFile);
//        XWPFTable table = document.getTables ().get (0);
//        XWPFTableRow row = table.getRow (0);
//        XWPFTableCell cell = row.getCell (0);
//        cell.setText (" 123");
//        cell = row.getCell (1);
//        cell.setText (" 20-12-2022");
//        table = document.getTables ().get (2);
//        row = table.createRow ();
//        cell = row.getCell (0);
//        cell.setText ("1");
//        setCellAlign(cell);
//        cell = row.getCell (1);
//        cell.setText ("2");
//        setCellAlign(cell);
//        cell = row.getCell (2);
//        cell.setText ("3");
//        setCellAlign(cell);
//        cell = row.getCell (3);
//        cell.setText ("4");
//        setCellAlign(cell);
//        cell = row.getCell (4);
//        cell.setText ("5");
//        setCellAlign(cell);
//        document.write (out);
//        out.close ();
        return "ok";
    }



}
