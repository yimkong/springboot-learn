package com.example.demo.async;

import org.springframework.stereotype.Component;

/**
 * author yg
 * description 需要在外部类调用才能起作用
 * date 2020/2/15
 */
@Component
public class Async {
    @org.springframework.scheduling.annotation.Async
    public void save() {
        System.err.println(Thread.currentThread().getName());
    }
}
