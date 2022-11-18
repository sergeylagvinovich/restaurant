package com.restaurant.Services.Main.impl;

import com.restaurant.Dao.CardDao;
import com.restaurant.Dto.Main.CartDishesDto;
import com.restaurant.Dto.Main.CartPage;
import com.restaurant.Dto.Main.CartUserInfoDto;
import com.restaurant.Facade.HelpFacade;
import com.restaurant.Mappers.Administration.Users.UserMapper;
import com.restaurant.Mappers.Main.CartMapper;
import com.restaurant.Mappers.Main.DishMapper;
import com.restaurant.Models.*;
import com.restaurant.Services.Main.CardService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class CardServiceImpl implements CardService {

    private final CartMapper cartMapper
            = Mappers.getMapper(CartMapper.class);

    private final UserMapper userMapper
            = Mappers.getMapper(UserMapper.class);

    @Autowired
    private CardDao cardDao;


    @Override
    public Boolean addToCard(Dish dish) {
        User user = HelpFacade.getUser();
        Card card = cardDao.findByUser_IdAndInOrder(user.getId(),false);
        if(card!=null){
            Boolean dishInCard = card.getDishes().stream().filter(x->x.getDish().equals(dish)).count()>0;
            if(dishInCard){
                CardDishes cardDishes = card.getDishes().stream().filter(x->x.getDish().equals(dish)).findFirst().get();
                cardDishes.setCount(cardDishes.getCount()+1);
            }else {
                CardDishes cardDishes = new CardDishes();
                cardDishes.setCount(1);
                cardDishes.setCard(card);
                cardDishes.setDish(dish);
                card.getDishes().add(cardDishes);
            }
        }
        else{
            card = new Card();
            card.setUser(user);
            card.setInOrder(false);
            CardDishes cardDishes = new CardDishes();
            cardDishes.setCount(1);
            cardDishes.setCard(card);
            cardDishes.setDish(dish);
            card.getDishes().add(cardDishes);

        }
        cardDao.save(card);
        return true;
    }

    @Override
    public Boolean removeFromCard(Dish dish) {
        return null;
    }

    @Override
    public CartPage getCart() {
        User user = HelpFacade.getUser();
        Card card = cardDao.findByUser_IdAndInOrder(user.getId(),false);
        return new CartPage(cartMapper.modelToDto(card), userMapper.userToCartUserInfo(user));
    }
}
