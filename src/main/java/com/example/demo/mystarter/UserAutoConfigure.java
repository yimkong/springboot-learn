package com.example.demo.mystarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author yg
 * description 自动配置类
 * date 2020/2/17
 */
@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfigure {
    @Bean
    @ConditionalOnProperty(prefix = "spring.user", value = "enable", havingValue = "true")
    public UserClient client(UserProperties userProperties) {
        return new UserClient(userProperties);
    }
}
