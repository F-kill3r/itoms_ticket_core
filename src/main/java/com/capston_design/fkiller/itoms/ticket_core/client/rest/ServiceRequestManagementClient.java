package com.capston_design.fkiller.itoms.ticket_core.client.rest;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-request-management", url = "${SERVICE_REQUEST_MANAGEMENT_URL}")
public interface ServiceRequestManagementClient {
    // TODO: Task api 완료되면 구현
}
