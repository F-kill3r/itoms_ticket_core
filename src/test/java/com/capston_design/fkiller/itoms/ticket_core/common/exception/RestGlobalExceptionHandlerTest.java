package com.capston_design.fkiller.itoms.ticket_core.common.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({RestGlobalExceptionHandler.class})
@WebMvcTest(controllers = TestController.class)
class RestGlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void 핸들러에_detail_없이_예외발생 ()  throws Exception {
        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/test/exception"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message").value("예외 발생"))
                .andExpect(jsonPath("$.detail").doesNotExist());
    }

    @Test
    void 핸들러에_detail_있는상태에서_예외발생 ()  throws Exception {
        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/test/exception/detail"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message").value("예외 발생"))
                .andExpect(jsonPath("$.detail.ticketCode").value(12))
                .andExpect(jsonPath("$.detail.message").value("티켓 전송 중 오류 발생"));
    }

}