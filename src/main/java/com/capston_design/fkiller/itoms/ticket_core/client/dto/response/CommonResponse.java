package com.capston_design.fkiller.itoms.ticket_core.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonResponse<T> {
    private boolean isSuccess;
    private String code;
    private String message;
    private T result;
}
