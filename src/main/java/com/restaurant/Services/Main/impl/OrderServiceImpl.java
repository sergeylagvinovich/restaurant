package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.*;
import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Mappers.Main.CartMapper;
import com.restaurant.Mappers.Main.OrderMapper;
import com.restaurant.Models.*;
import com.restaurant.Models.Card;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;
import com.restaurant.Models.User;
import com.restaurant.Services.Main.OrderService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.aspectj.util.FileUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.transaction.Transactional;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final CartMapper cartMapper
            = Mappers.getMapper(CartMapper.class);

    private final OrderMapper orderMapper
            = Mappers.getMapper(OrderMapper.class);


    @Autowired
    private UsersDao usersDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderStatusDao orderStatusDao;

    @Autowired
    private DocumentsDao documentsDao;

    @Autowired
    private CardDao cardDao;
    @Autowired
    private CardDishesDao cardDishesDao;
    @Override
    @Transactional
    public Boolean createOrder(CreateOrderDto createOrderDto) throws IOException {
        User user = HelpFacade.getUser();
        user.setPhone(createOrderDto.getPhone());
        user.setAddress(createOrderDto.getAddress());
        usersDao.save(user);
        Card cardDto = cartMapper.dtoToModel(createOrderDto);
        Card card = cardDao.findById(cardDto.getId()).get();
        card.setInOrder(true);
        card.setDishes(cardDto.getDishes());
        card = cardDao.save(card);
//        cardDishesDao.saveAll(card.getDishes());
        Order order = orderMapper.createOrderDtoToModel(createOrderDto);
        order.setUser(user);
        order.setCard(card);
        order.setOrderStatus(orderStatusDao.findById(1).get());
        order = orderDao.save(order);
        this.createDocument(order);
        return true;
    }

    @Override
    public OrdersPageDto getOrders(Integer priority) {
        User user = HelpFacade.getUser();
        List<Order> freeOrders = orderDao.findOrderByOrderStatusPriorityOrderById(priority);
        List<Order> myOrders = orderDao.findOrderByExecutorIdOrderById(user.getId());
        OrdersPageDto page = new OrdersPageDto();
        page.setFreeOrders(orderMapper.ordersToPageOrderList(freeOrders));
        page.setMyOrders(orderMapper.ordersToPageOrderList(myOrders));
        return page;
    }

    @Override
    public OrdersPageDto getOrdersUser() {
        User user = HelpFacade.getUser();
        List<Order> endOrders = orderDao.findOrderByUserIdAndOrderStatusId(user.getId (),8);
        List<Order> inProcess = orderDao.findOrderByUserIdAndOrderStatusIdIsLessThan(user.getId(),8);
        OrdersPageDto page = new OrdersPageDto();
        page.setFreeOrders(orderMapper.ordersToPageOrderList(endOrders));
        page.setMyOrders(orderMapper.ordersToPageOrderList(inProcess));
        return page;
    }

    @Override
    public boolean setStatus(Integer status, Order order) throws IOException {
        if(status==9 || status==2 || status==6){
            User user = HelpFacade.getUser();
            order.setExecutor(user);
        }
        switch (status){
            case 9:{
                this.addInDocument(order.getDocument().getFilePath(),order.getExecutor().getName(),0);
                break;
            }
            case 5:{
                this.addInDocument(order.getDocument().getFilePath(),order.getExecutor().getName(),1);
                break;
            }
            case 8:{
                this.addInDocument(order.getDocument().getFilePath(),order.getExecutor().getName(),2);
                break;
            }
        }

        order.setOrderStatus(orderStatusDao.findById(status).get());
        orderDao.save(order);
        return true;
    }

    private void addInDocument(String filePath, String userName, Integer rowIndex) throws IOException {
        File original = new File (filePath);
        XWPFDocument document = new XWPFDocument (new FileInputStream (original));
        XWPFTable table  = document.getTables ().get (4);
        table.getRow(rowIndex).getCell(1).setText(userName);
        FileOutputStream out = new FileOutputStream (original);
        document.write (out);
        out.close ();
    }



    @Value("${path.template}")
    String pathTemplate;
    @Value("${path.to.save.order}")
    String savePath;
    private void createDocument(Order order) throws IOException {
//        XWPFDocument documentnt = new XWPFDocument ();
//        HelpFacade.createDocument (null);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String fileName = myDateObj.format(myFormatObj);

        myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String saveTo = savePath+fileName+".docx";
        File original = new File (pathTemplate);
        File newFile = new File (saveTo);
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
        Document file = new Document();
        file.setName(fileName);
        file.setFilePath(saveTo);
        file = documentsDao.save(file);
        order.setDocument(file);
        orderDao.save(order);
    }
}
