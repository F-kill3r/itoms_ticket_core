package com.capston_design.fkiller.itoms.ticket_core.common.exception.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Builder
@Getter
public class RestBaseErrorResponseDTO<T> {
    private String message;
    @Nullable
    private T detail;
}
