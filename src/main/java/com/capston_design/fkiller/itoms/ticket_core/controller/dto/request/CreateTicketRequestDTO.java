package com.capston_design.fkiller.itoms.ticket_core.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateTicketRequestDTO {
    private UUID incidentId;
    private RequesterDTO requester;
}
