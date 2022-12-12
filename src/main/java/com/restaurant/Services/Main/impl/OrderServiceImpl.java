package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.CardDao;
import com.restaurant.Dao.CardDishesDao;
import com.restaurant.Dao.OrderDao;
import com.restaurant.Dao.OrderStatusDao;
import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Dto.Orders.OrdersPageDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Mappers.Main.CartMapper;
import com.restaurant.Mappers.Main.OrderMapper;
import com.restaurant.Models.Card;
import com.restaurant.Models.Order;
import com.restaurant.Models.OrderStatus;
import com.restaurant.Models.User;
import com.restaurant.Services.Main.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
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
    private CardDao cardDao;
    @Autowired
    private CardDishesDao cardDishesDao;
    @Override
    @Transactional
    public Boolean createOrder(CreateOrderDto createOrderDto) {
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
        orderDao.save(order);
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
    public boolean setStatus(Integer status, Order order) {
        if(status==2 || status==6){
            User user = HelpFacade.getUser();
            order.setExecutor(user);
        }
        order.setOrderStatus(orderStatusDao.findById(status).get());
        orderDao.save(order);
        return true;
    }
}
