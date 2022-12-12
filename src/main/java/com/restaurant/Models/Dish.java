package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish extends BaseModel {

    @Column
    private String name;

    @Column
    private float price;

    @Column
    private String imgPath;

    @ManyToOne
    private DishType dishType;

    @OneToMany(mappedBy = "dish")
    private Set<DishProducts> dishProducts;


}
