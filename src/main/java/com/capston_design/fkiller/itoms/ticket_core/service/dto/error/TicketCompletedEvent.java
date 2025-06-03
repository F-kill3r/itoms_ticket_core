package com.capston_design.fkiller.itoms.ticket_core.service.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TicketCompletedEvent {
    private UUID ticketId;
    private UUID incidentId;
}
