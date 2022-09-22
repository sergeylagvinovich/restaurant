package com.restaurant.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserRoles> roles;

    @Column
    private Boolean isActive;
}
