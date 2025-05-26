package com.capston_design.fkiller.itoms.ticket_core.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateTicketRequestDTO {
    private String incidentId;
    private RequesterDTO requester;
}
