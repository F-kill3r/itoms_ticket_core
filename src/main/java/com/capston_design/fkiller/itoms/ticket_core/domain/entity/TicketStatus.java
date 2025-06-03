package com.capston_design.fkiller.itoms.ticket_core.domain.entity;

import com.capston_design.fkiller.itoms.ticket_core.common.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TicketStatus {
    REQUEST_CREATE_TICKET(1, "REQUEST", "티켓 생성 요청 상태"),
    COMPLETE_ASSIGN_CREATOR(2, "CREATED", "티켓 담당자 할당 완료 상태"),
    PENDING_EXECUTION(3, "PENDING_EXECUTION", "승인 대기 상태(작업자가 티켓 업무를 수행하기 전 대기 상태)"),
    DEACTIVATE_EXECUTION(4, "NOT_STARTED_EXECUTION", "승인은 완료했으나 과업 수행 시작 전 상태(planStartDate 전인 경우)"),
    ACTIVATE_EXECUTION(5, "IN_PROGRESS", "작업자가 작업 진행 중 상태"),
    COMPLETE_EXECUTION(6, "COMPLETE_EXECUTION", "전체 과업이 완료되어, 해당 티켓의 수행이 종료 상태"),
    CANCEL_EXECUTION(7, "REJECTED", "작업자가 티켓 수행 불가로 반려한 상태"),
    PAUSED_EXECUTION(9, "HOLD_ON", "작업자가 티켓 수행을 일시 중지한 상태");
    private int code;
    private String codeName;
    private String description;

    TicketStatus(int code, String codeName, String description) {
        this.code = code;
        this.codeName = codeName;
        this.description = description;
    }

    public static TicketStatus fromCodeName(String ticketStatus) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.getCodeName().equals(ticketStatus)) {
                return status;
            }
        }
        throw BaseException.createBaseExceptionWithoutDetail(
                HttpStatus.BAD_REQUEST, "정의되지 않은 TicketStatus 코드명입니다.");
    }
}
