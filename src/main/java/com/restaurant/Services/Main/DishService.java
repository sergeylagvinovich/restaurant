package com.restaurant.Services.Main;

import com.restaurant.Dto.Main.DishDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishService {

    List<DishDto> getDishByType(Integer type);

}
