package com.capston_design.fkiller.itoms.ticket_core.infra.grpc.config;

import com.capston_design.fkiller.itoms.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Value("${USER_HOST}")
    private String userServiceHost;

    @Value("${USER_PORT}")
    private int userServicePort;

    @Value("${INCIDENT_HOST}")
    private String incidentServiceHost;

    @Value("${INCIDENT_PORT}")
    private int incidentServicePort;

    @Bean
    public ManagedChannel userServiceChannel() {
        return ManagedChannelBuilder.forAddress(userServiceHost, userServicePort)
                .usePlaintext()
                .build();
    }

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userClientStub(ManagedChannel userServiceChannel) {
        return UserServiceGrpc.newBlockingStub(userServiceChannel);
    }

    @Bean
    public ManagedChannel incidentServiceChannel() {
        return ManagedChannelBuilder.forAddress(incidentServiceHost, incidentServicePort)
                .usePlaintext()
                .build();
    }


}
