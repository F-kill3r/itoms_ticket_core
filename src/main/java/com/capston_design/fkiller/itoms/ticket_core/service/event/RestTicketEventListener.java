package com.capston_design.fkiller.itoms.ticket_core.service.event;

import com.capston_design.fkiller.itoms.ticket_core.client.rest.IncidentClient;
import com.capston_design.fkiller.itoms.ticket_core.client.dto.TicketCompletedRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.dto.error.TicketCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestTicketEventListener {
    private final IncidentClient incidentClient;

    @Async
    @EventListener
    public void handleTicketCompletedEvent(TicketCompletedEvent event) {
        incidentClient.completeTicket(new TicketCompletedRequestDTO(event.getTicketId(), event.getIncidentId()));
    }
}
