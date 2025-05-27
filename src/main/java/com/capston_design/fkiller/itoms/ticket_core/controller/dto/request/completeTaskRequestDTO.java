package com.capston_design.fkiller.itoms.ticket_core.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class completeTaskRequestDTO {
    private UUID ticketId;
    private String taskName;
}
