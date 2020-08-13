package com.liuxin.vo;

import com.liuxin.domain.Account;
import com.liuxin.domain.Role;
import com.liuxin.domain.User;

import java.util.List;

public class UserVo extends User {
    private Account account;
    private List<Role> roles;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + this.getId() +
                ", username='" + this.getUsername() + '\'' +
                ", birthday=" + this.getBirthday() +
                ", sex='" + this.getSex() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ",account=" + account +'\''+
                ",roles=" + roles +
                '}';

    }

}
