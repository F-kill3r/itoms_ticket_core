package com.capston_design.fkiller.itoms.ticket_core.service;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.*;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.TicketInfoResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    UUID createTicket(CreateTicketRequestDTO request);
    void assignAcceptor(UUID ticketId, AssignAcceptorRequestDTO dto);
    void assignHandler(AssignmentCallbackDTO dto);
    void updateTicketInfo(UUID ticketId, UpdateTicketInfoRequestDTO request);
    List<TicketInfoResponseDTO> findTicketsByAcceptorId(String acceptorId);
    void updateTicketStatus(completeTicketRequestDTO request);
}
