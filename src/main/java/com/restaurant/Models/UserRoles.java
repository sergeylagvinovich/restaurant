package com.restaurant.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private User user;

    @Column
    private Boolean canInsert;

    @Column
    private Boolean canUpdate;

    @Column
    private Boolean canDelete;

    @Column
    private Boolean canView;

}
