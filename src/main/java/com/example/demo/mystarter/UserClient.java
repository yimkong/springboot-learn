package com.example.demo.mystarter;

/**
 * author yg
 * description
 * date 2020/2/17
 */
public class UserClient {
    private UserProperties userProperties;

    public UserClient(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public UserProperties getUserProperties() {
        return userProperties;
    }

    public void setUserProperties(UserProperties userProperties) {
        this.userProperties = userProperties;
    }
}
