package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseModel {

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "card")
    private Set<CardDishes> dishes;

    @Column
    private Boolean inOrder;



}
