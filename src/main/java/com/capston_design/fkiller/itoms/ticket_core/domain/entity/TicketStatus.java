package com.capston_design.fkiller.itoms.ticket_core.domain.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    REQUEST_CREATE_TICKET(1, "REQUEST", "티켓 생성 요청 상태"),
    COMPELETE_ASSIGN_ACCEPTOR(2, "ASSIGNED", "작업자 할당 완료 상태");

    private int code;
    private String codeName;
    private String description;

    TicketStatus(int code, String codeName, String description) {
        this.code = code;
        this.codeName = codeName;
        this.description = description;
    }
}
