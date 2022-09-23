package com.restaurant.Models;


import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel  {

    @Column
    private String name;

    @Column
    private Float countInStore;

    @ManyToOne
    private Unit unit;

}
