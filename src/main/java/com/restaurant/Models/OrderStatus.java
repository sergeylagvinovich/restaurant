package com.restaurant.Models;


import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_statuses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus extends BaseModel {

    @Column
    private String name;
}
