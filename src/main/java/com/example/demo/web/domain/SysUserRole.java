package com.example.demo.web.domain;

import java.io.Serializable;

/**
 * author yg
 * description
 * date 2020/3/26
 */
public class SysUserRole implements Serializable {
    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
