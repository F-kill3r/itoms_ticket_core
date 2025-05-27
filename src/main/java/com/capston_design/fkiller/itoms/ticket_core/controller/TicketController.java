package com.capston_design.fkiller.itoms.ticket_core.controller;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignAcceptorRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.UpdateTicketInfoRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.CreateTicketResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("/v1/ticket/{ticketId}/assign")
    public ResponseEntity<Void> assignAcceptor(
            @PathVariable UUID id,
            @RequestBody AssignAcceptorRequestDTO request
    ) {
        ticketService.assignAcceptor(id, request);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/v1/ticket/{ticketId}")
    public ResponseEntity<Void> updateTicket(
            @PathVariable UUID id,
            @RequestBody UpdateTicketInfoRequestDTO request
    ) {
        ticketService.updateTicketInfo(id, request);
        return ResponseEntity.ok().build();
    }
}
