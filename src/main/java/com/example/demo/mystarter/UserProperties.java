package com.example.demo.mystarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * author yg
 * description
 * date 2020/2/17
 */
@Data
@ConfigurationProperties("spring.user")
public class UserProperties {
    private String name;
}
