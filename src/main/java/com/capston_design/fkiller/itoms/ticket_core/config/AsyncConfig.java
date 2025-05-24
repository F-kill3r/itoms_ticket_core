package com.capston_design.fkiller.itoms.ticket_core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Slf4j
@Configuration
public class AsyncConfig {

    @Bean
    public Executor asyncExecutor() {
        log.info("asyncExecutor 스레드 초기화");
        ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
        asyncExecutor.setCorePoolSize(3);
        asyncExecutor.setMaxPoolSize(5);
        asyncExecutor.setQueueCapacity(10);
        asyncExecutor.setThreadNamePrefix("Async-");
        asyncExecutor.initialize();
        return asyncExecutor;
    }
}
