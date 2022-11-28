package com.restaurant.Facade;

import com.restaurant.Dao.DocumentsDao;
import com.restaurant.Models.Document;
import com.restaurant.Models.Order;
import com.restaurant.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.context.SecurityContextHolder;

public class HelpFacade {

    public static User getUser(){
        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        return  (User) principal;
    }


}
