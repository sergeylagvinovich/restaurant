package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dish_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishType extends BaseModel {

    @Column
    private String name;

    @OneToMany(mappedBy = "dishType")
    private Set<Dish> dishes;

}
