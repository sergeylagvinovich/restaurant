package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.CardDao;
import com.restaurant.Dao.CardDishesDao;
import com.restaurant.Dao.OrderDao;
import com.restaurant.Dto.Main.CreateOrderDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Mappers.Administration.Users.UserMapper;
import com.restaurant.Mappers.Main.CartMapper;
import com.restaurant.Mappers.Main.OrderMapper;
import com.restaurant.Models.Card;
import com.restaurant.Models.Order;
import com.restaurant.Models.User;
import com.restaurant.Services.Main.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

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
        orderDao.save(order);
        return true;
    }
}
