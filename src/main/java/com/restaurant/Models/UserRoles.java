package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles extends BaseModel implements GrantedAuthority {

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

    @Override
    public String getAuthority() {
        return getRole().getName();
    }
}
