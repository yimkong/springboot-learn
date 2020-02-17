package com.example.demo.configControl;

import com.example.demo.mystarter.UserAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * author yg
 * description 通过注解开启自动配置，则不需要spring.factories文件了
 * date 2020/2/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({UserAutoConfigure.class})
public @interface EnableUserClient {

}
