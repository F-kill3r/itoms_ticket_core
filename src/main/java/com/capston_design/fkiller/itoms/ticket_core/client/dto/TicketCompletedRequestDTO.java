package com.capston_design.fkiller.itoms.ticket_core.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TicketCompletedRequestDTO {
    private UUID ticketId;
    private UUID incidentId;
}
