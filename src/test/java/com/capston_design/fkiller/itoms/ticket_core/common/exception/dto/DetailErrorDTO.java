package com.capston_design.fkiller.itoms.ticket_core.common.exception.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DetailErrorDTO {
    private String ticketCode;
    private String message;

    public DetailErrorDTO(String ticketCode, String message) {
        this.ticketCode = ticketCode;
        this.message = message;
    }
}
