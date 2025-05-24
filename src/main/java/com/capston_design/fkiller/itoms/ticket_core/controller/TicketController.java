package com.capston_design.fkiller.itoms.ticket_core.controller;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.CreateTicketResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/ticket-core")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //TODO: 전역 Response 응답타입 정의
    @PostMapping("/v1/ticket")
    public CreateTicketResponseDTO createTicket(@RequestBody CreateTicketRequestDTO request) {
        UUID ticketId = ticketService.createTicket(request);
        return new CreateTicketResponseDTO(ticketId);
    }
}
