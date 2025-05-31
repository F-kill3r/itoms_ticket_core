package com.capston_design.fkiller.itoms.ticket_core.client.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "incident" , url = "${INCIDENT_URL}")
public interface IncidentClient {
    // TODO: Incident api 완료되면 구현
}
