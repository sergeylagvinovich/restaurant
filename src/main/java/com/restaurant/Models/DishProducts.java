package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dish_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishProducts extends BaseModel {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Dish dish;

    @Column
    private Integer orderNum;

    @Column
    private String text;
}
