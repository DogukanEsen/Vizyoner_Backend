package com.example.vizyonervizyoner.User;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer roleId;
    @Column(name = "name")
    private String authority;

    public Role() {
        super();
    }

    public Role(Integer roleId, String authority) {
        this.roleId = roleId;
        authority = authority;
    }

    public Role(String authority){
        this.authority = authority;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setAuthority(String authority) {
        authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
