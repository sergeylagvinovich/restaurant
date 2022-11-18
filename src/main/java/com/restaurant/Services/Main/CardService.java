package com.restaurant.Services.Main;

import com.restaurant.Dto.Main.CartPage;
import com.restaurant.Models.Dish;

public interface CardService {

    Boolean addToCard(Dish dish);
    Boolean removeFromCard(Dish dish);

    CartPage getCart();

//    Boolean saveCard();
}
