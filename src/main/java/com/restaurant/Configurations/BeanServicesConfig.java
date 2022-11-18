package com.restaurant.Configurations;

import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Services.Administration.Roles.AdministrationRoleService;
import com.restaurant.Services.Administration.Roles.impl.AdministrationRoleServiceImpl;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import com.restaurant.Services.Administration.Users.impl.AdministrationUserServiceImpl;
import com.restaurant.Services.Main.CardService;
import com.restaurant.Services.Main.DishService;
import com.restaurant.Services.Main.OrderService;
import com.restaurant.Services.Main.impl.CardServiceImpl;
import com.restaurant.Services.Main.impl.DishServiceImpl;
import com.restaurant.Services.Main.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicesConfig {

    @Bean
    public AdministrationUserService getAdministrationUserService() {
        return new AdministrationUserServiceImpl ();
    }

    @Bean
    public AdministrationRoleService getAdministrationRoleService() {
        return new AdministrationRoleServiceImpl ();
    }

    @Bean
    public DishService getDishService(){
        return new DishServiceImpl ();
    }

    @Bean
    public CardService getCardService(){
        return new CardServiceImpl();
    }

    @Bean
    public OrderService getOrderService(){
        return new OrderServiceImpl();
    }

}
