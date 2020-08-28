package com.ipnetinstitute.csc394.backend.entity;

import java.util.Set;

public class UserRoleWP {
    User user;
    Set<Role> roles;

    public UserRoleWP() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
