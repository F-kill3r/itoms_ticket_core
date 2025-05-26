package com.capston_design.fkiller.itoms.ticket_core.controller.dto.request;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AssignmentCallbackDTO {
    private UUID ticketId;
    private String creatorId;
    private String creatorName;
}
