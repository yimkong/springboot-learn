package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * author yg
 * description
 * date 2020/2/15
 */
@Component
public class Async {
    @org.springframework.scheduling.annotation.Async
    public void save() {
        System.err.println(Thread.currentThread().getName());
    }
}
