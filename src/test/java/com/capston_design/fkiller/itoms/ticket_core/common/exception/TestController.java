package com.capston_design.fkiller.itoms.ticket_core.common.exception;

import com.capston_design.fkiller.itoms.ticket_core.common.exception.dto.DetailErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.capston_design.fkiller.itoms.ticket_core.common.exception.BaseException.createBaseExceptionWithDetail;
import static com.capston_design.fkiller.itoms.ticket_core.common.exception.BaseException.createBaseExceptionWithoutDetail;

@Controller
public class TestController {

    @GetMapping("/test/exception")
    public ResponseEntity<Void> testException() {
        throw createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST, "예외 발생");
    }

    @GetMapping("/test/exception/detail")
    public ResponseEntity<Void> testExceptionWithDetail() {
        throw createBaseExceptionWithDetail(HttpStatus.BAD_REQUEST, "예외 발생", new DetailErrorDTO("12", "티켓 전송 중 오류 발생"));
    }
}