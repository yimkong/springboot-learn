package com.example.demo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author yg
 * description 自定义端点 TODO 不成功待查问题
 * http://localhost:8080/actuator/user
 * date 2020/2/15
 */
@Component
@Endpoint(id="user")
public class UserEndPoint {
    @ReadOperation
    public List<Map<String, Object>> health() {
        List<Map<String, Object>> list=new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", 1001);
        map.put("userName", "yimkong");
        list.add(map);
        return list;
    }
}
