/**
 * Object For handling SpringSecurity User and holding User
 * throughout the Session.
 */


package com.company.employeeattendance.dtos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomAuth extends User {

    private com.company.employeeattendance.entities.User user;


    public CustomAuth(com.company.employeeattendance.entities.User user, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public com.company.employeeattendance.entities.User getUser() {
        return user;
    }

    public void setUser(com.company.employeeattendance.entities.User user) {
        this.user = user;
    }
}
