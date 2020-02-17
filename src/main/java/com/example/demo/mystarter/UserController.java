package com.example.demo.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author yg
 * description
 * date 2020/2/17
 */
@RestController
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/user/name")
    public String getUserName() {
        return userClient.getUserProperties().getName();
    }
}
