package com.example.demo.web.domain;

import java.io.Serializable;

/**
 * author yg
 * description
 * date 2020/3/26
 */
public class SysUser implements Serializable {

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
