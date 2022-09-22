package com.restaurant.Models;

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
public class CardDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Dish dish;

    @ManyToOne
    private  Card card;
}
