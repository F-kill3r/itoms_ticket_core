package com.capston_design.fkiller.itoms.ticket_core.common.exception;

import com.capston_design.fkiller.itoms.ticket_core.common.exception.dto.RestBaseErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestGlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<RestBaseErrorResponseDTO<?>> handleRestBaseException(BaseException e) {
        log.error(e.getMessage());
        RestBaseErrorResponseDTO<?> restBaseErrorResponse = RestBaseErrorResponseDTO.builder()
                .message(e.getMessage())
                .detail(e.getDetail())
                .build();
        return ResponseEntity.status(e.getHttpStatus()).body(restBaseErrorResponse);
    }
}
