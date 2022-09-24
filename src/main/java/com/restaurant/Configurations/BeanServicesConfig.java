package com.restaurant.Configurations;

import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import com.restaurant.Services.Administration.Users.impl.AdministrationUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicesConfig {

    @Bean
    public AdministrationUserService getAdministrationUserService() {
        return new AdministrationUserServiceImpl ();
    }

}
