package com.restaurant.Dto.Main;

import com.restaurant.Models.Dish;
import com.restaurant.Models.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class DishProductsDto {

    private String productName;

}
