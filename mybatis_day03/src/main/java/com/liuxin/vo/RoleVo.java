package com.liuxin.vo;

import com.liuxin.domain.Role;
import com.liuxin.domain.User;

import java.util.List;

public class RoleVo extends Role {
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + this.getId() +
                ", roleName='" + getRoleName() + '\'' +
                ", roleDesc='" + getRoleDesc() + '\'' +
                "user=" + user +
                '}';
    }
}
