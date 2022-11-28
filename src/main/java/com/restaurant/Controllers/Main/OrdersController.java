package com.restaurant.Controllers.Main;

import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Services.Main.OrderService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.aspectj.util.FileUtil;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

    @GetMapping
    public String tets() throws IOException {
//        XWPFDocument document = new XWPFDocument ();
        HelpFacade.createDocument (null);
        File original = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\templates\\templateOrder.docx");
        File newFile = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\orderTest.docx");
        FileUtil.copyFile(original,newFile);
        XWPFDocument document = new XWPFDocument (new FileInputStream (newFile));

        FileOutputStream out = new FileOutputStream (newFile);
        XWPFTable table = document.getTables ().get (0);
        XWPFTableRow row = table.getRow (0);
        XWPFTableCell cell = row.getCell (0);
        cell.setText (" 123");
        cell = row.getCell (1);
        cell.setText (" 20-12-2022");
        table = document.getTables ().get (2);
        row = table.createRow ();
        cell = row.getCell (0);
        cell.setText ("1");
        setCellAlign(cell);
        cell = row.getCell (1);
        cell.setText ("2");
        setCellAlign(cell);
        cell = row.getCell (2);
        cell.setText ("3");
        setCellAlign(cell);
        cell = row.getCell (3);
        cell.setText ("4");
        setCellAlign(cell);
        cell = row.getCell (4);
        cell.setText ("5");
        setCellAlign(cell);
        document.write (out);
        out.close ();
        return "ok";
    }

    private void setCellAlign(XWPFTableCell cell){
        CTTc cttc = cell.getCTTc();
        CTP ctp = cttc.getPList().get(0);
        CTPPr ctppr = ctp.getPPr();
        if (ctppr == null) {
            ctppr = ctp.addNewPPr();
        }
        CTJc ctjc = ctppr.getJc();
        if (ctjc == null) {
            ctjc = ctppr.addNewJc();
        }
        ctjc.setVal(STJc.LEFT);
    }

}
