package com.example.demo;

import com.example.demo.async.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author yg
 * description
 * date 2020/2/12
 */
@RestController
public class Hello {
    @Autowired
    private Environment env;
    @Value("${server.port}")
    private String port;
    @Autowired
    private MyConfig config;
    @Autowired
    private Async async;

    @GetMapping("/hello")
    private String hello() {
        return env.getProperty("server.port");
    }

    @GetMapping("/hi")
    private String hi() {
        return port;
    }

    @GetMapping("/my")
    private String my() {
        return config.getName();
    }

    @GetMapping("/myage")
    private int myage() {
        return config.getAge();
    }

    @GetMapping("/weight")
    private int weight() {
        return config.getWeight();
    }

    @GetMapping("/testAsync")
    private void async() {
        System.err.println(Thread.currentThread().getName());
        async.save();
    }

}