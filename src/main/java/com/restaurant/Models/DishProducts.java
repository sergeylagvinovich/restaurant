package com.restaurant.Models;

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
public class DishProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Dish dish;

    @Column
    private Integer orderNum;

    @Column
    private String text;
}
