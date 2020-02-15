package com.example.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * author yg
 * description 配置异步线程池
 * date 2020/2/15
 */
@Configuration
@Slf4j
public class ExecutePool implements AsyncConfigurer {
    @Autowired
    private AsyncConfig asyncConfig;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(asyncConfig.getPoolSize());
        threadPoolExecutor.setMaxPoolSize(asyncConfig.getMaxPoolSize());
        threadPoolExecutor.setKeepAliveSeconds(asyncConfig.getKeepAlive());
        threadPoolExecutor.setQueueCapacity(asyncConfig.getQueueCapacity());
        threadPoolExecutor.setThreadNamePrefix(asyncConfig.getThreadNamePrefix());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            log.error("==========" + throwable.getMessage() + "========", throwable);
            log.error("method:[{}]", method.getName());
        };
    }
}
