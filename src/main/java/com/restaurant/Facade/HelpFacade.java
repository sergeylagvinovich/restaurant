package com.restaurant.Facade;

import com.restaurant.Models.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class HelpFacade {

    public static User getUser(){
        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        return  (User) principal;
    }

}
