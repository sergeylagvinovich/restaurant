package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Card card;

    @ManyToOne
    private OrderStatus orderStatus;

    @ManyToOne
    private Document document;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private LocalDateTime orderDate;

    @Column
    private Boolean needCall;

    @ManyToOne
    private User executor;


}
