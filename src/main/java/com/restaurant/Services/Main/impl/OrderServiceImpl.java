package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.CardDao;
import com.restaurant.Dao.CardDishesDao;
import com.restaurant.Dao.OrderDao;
import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Mappers.Main.CartMapper;
import com.restaurant.Mappers.Main.OrderMapper;
import com.restaurant.Models.*;
import com.restaurant.Services.Main.OrderService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.aspectj.util.FileUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderServiceImpl implements OrderService {

    private final CartMapper cartMapper
            = Mappers.getMapper(CartMapper.class);

    private final OrderMapper orderMapper
            = Mappers.getMapper(OrderMapper.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CardDao cardDao;
    @Autowired
    private CardDishesDao cardDishesDao;
    @Override
    @Transactional
    public Boolean createOrder(CreateOrderDto createOrderDto) {
        User user = HelpFacade.getUser();
        Card cardDto = cartMapper.dtoToModel(createOrderDto);
        Card card = cardDao.findById(cardDto.getId()).get();
        card.setInOrder(true);
        card.setDishes(cardDto.getDishes());
        card = cardDao.save(card);
//        cardDishesDao.saveAll(card.getDishes());
        Order order = orderMapper.createOrderDtoToModel(createOrderDto);
        order.setUser(user);
        order.setCard(card);
        order = orderDao.save(order);
        try {
            createDocument (order);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        return true;
    }

    private void createDocument(Order order) throws IOException {
//        XWPFDocument documentnt = new XWPFDocument ();
//        HelpFacade.createDocument (null);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String fileName = myDateObj.format(myFormatObj);

        myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        File original = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\templates\\templateOrder.docx");
        File newFile = new File ("D:\\Projects\\restaurant\\src\\main\\resources\\files\\"+fileName+".docx");
        FileUtil.copyFile(original,newFile);
        XWPFDocument document = new XWPFDocument (new FileInputStream (newFile));

        FileOutputStream out = new FileOutputStream (newFile);
        XWPFTable table = document.getTables ().get (0);
        XWPFTableRow row = table.getRow (0);
        XWPFTableCell cell = row.getCell (0);
        cell.setText (order.getId ().toString ());
        cell = row.getCell (1);
        String date = myDateObj.format(myFormatObj);
        cell.setText (date);

        table = document.getTables ().get (1);
        table.getRow (0).getCell (1).setText (order.getUser ().getName ());
        table.getRow (1).getCell (1).setText (order.getAddress ());
        table.getRow (2).getCell (1).setText (order.getPhone ());
        //блюда
        table = document.getTables ().get (2);
        Integer i = 1;
        DecimalFormat df = new DecimalFormat ("#.00");
        double totalDish = 0.0;
        for (CardDishes item : order.getCard ().getDishes ()) {
            row = table.createRow ();
            row.getCell (0).setText (i.toString ());
            row.getCell (1).setText (item.getDish ().getName ());
            row.getCell (2).setText (String.valueOf(item.getDish ().getPrice ()));
            row.getCell (3).setText (String.valueOf (item.getCount ()));
            row.getCell (4).setText (String.valueOf (item.getCount ()*item.getDish ().getPrice ()));
            i++;
            totalDish += item.getCount ()*item.getDish ().getPrice ();
        }


        table = document.getTables ().get (3);
        table.getRow (0).getCell (1).setText (df.format (totalDish));
        table.getRow (1).getCell (1).setText ("3.60");
        table.getRow (2).getCell (1).setText ("15.00");
        table.getRow (3).getCell (1).setText (df.format (totalDish+3.60+15.00));
        document.write (out);
        out.close ();
    }
}
