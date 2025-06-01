package com.capston_design.fkiller.itoms.ticket_core.controller;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignAcceptorRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.TicketInfoRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.UpdateTicketInfoRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.CreateTicketResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.TicketInfoResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticket-core")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    //TODO: 전역 Response 응답타입 정의
    @PostMapping("/v1/ticket")
    public CreateTicketResponseDTO createTicket(@RequestBody CreateTicketRequestDTO request) {
        UUID ticketId = ticketService.createTicket(request);
        return new CreateTicketResponseDTO(ticketId);
    }
    @PatchMapping("/v1/ticket/{ticketId}/assign")
    public ResponseEntity<Void> assignAcceptor(
            @PathVariable UUID ticketId,
            @RequestBody AssignAcceptorRequestDTO request
    ) {
        ticketService.assignAcceptor(ticketId, request);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/v1/ticket/{ticketId}")
    public ResponseEntity<Void> updateTicket(
            @PathVariable UUID ticketId,
            @RequestBody UpdateTicketInfoRequestDTO request
    ) {
        ticketService.updateTicketInfo(ticketId, request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("v1/tickets/by-acceptor")
    public ResponseEntity<List<TicketInfoResponseDTO>> getTicketsByAcceptorId(
            @RequestBody TicketInfoRequestDTO request) {
        List<TicketInfoResponseDTO> tickets = ticketService.findTicketsByAcceptorId(request.getAcceptorId());
        return ResponseEntity.ok(tickets);
    }
}
