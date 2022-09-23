package com.restaurant.Models;


import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "partners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partner extends BaseModel {

    @Column
    private String fullName;

    @Column
    private String shortName;

    @Column
    private String unp;

    @Column
    private String address;

    @Column
    private String legalAddress;

    @OneToMany
    private Set<Product> products;

}
