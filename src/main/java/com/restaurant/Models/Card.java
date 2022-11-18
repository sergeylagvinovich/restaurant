package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<CardDishes> dishes = new HashSet<>();

    @Column
    private Boolean inOrder;



}
