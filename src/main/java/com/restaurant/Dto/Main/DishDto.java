package com.restaurant.Dto.Main;

import com.restaurant.Models.DishProducts;
import com.restaurant.Models.DishType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
public class DishDto {

    private String name;
    private String price;
    private String imgPath;
    private Set<DishProductsDto> dishProducts;

}
