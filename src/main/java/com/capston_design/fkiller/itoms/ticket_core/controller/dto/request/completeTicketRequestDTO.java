package com.capston_design.fkiller.itoms.ticket_core.controller.dto.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class completeTicketRequestDTO {
    private UUID ticketId;
    private String ticketName;
    private String ticketStatus;
    private String completionTime;
}
