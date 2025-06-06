package com.capston_design.fkiller.itoms.ticket_core.client;

import com.capston_design.fkiller.itoms.ticket_core.client.dto.TicketCompletedRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "incident" , url = "${INCIDENT_URL}")
public interface IncidentClient {
    // TODO: Incident api 완료되면 구현

    // url path는 추후 변경예
    @PostMapping("/v1/ticket/complete")
    void completeTicket(@RequestBody TicketCompletedRequestDTO requestDTO);
}
