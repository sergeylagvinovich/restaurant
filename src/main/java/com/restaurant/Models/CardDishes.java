package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "card_dishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDishes extends BaseModel {

    @Column
    private int count;

    @ManyToOne
    private Dish dish;

    @ManyToOne
    private  Card card;
}
