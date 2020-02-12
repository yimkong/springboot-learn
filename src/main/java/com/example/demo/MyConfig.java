package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author yg
 * description 自定义配置类
 * date 2020/2/12
 */
@ConfigurationProperties(prefix = "com.yimkong")
@Component
public class MyConfig {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
