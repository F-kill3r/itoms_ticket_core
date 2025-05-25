package com.capston_design.fkiller.itoms.ticket_core.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateTicketResponseDTO {
    private UUID ticketId;
}
