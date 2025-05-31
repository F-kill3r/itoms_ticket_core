package com.capston_design.fkiller.itoms.ticket_core;

import com.capston_design.fkiller.itoms.ticket_core.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaAuditing
@EnableFeignClients(defaultConfiguration = FeignConfig.class)
@SpringBootApplication
public class TicketCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketCoreApplication.class, args);
    }

}
