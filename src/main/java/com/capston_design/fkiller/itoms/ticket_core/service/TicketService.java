package com.capston_design.fkiller.itoms.ticket_core.service;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;
import com.capston_design.fkiller.itoms.ticket_core.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public UUID createTicket(CreateTicketRequestDTO request){

        TicketStatus initStatus = TicketStatus.REQUEST_CREATE_TICKET;
        Ticket initTicket = Ticket.ofCreateBaseTicket(request.getIncidentId(),
                request.getRequester().getRequesterId(),
                request.getRequester().getRequesterName(), initStatus);
        //TODO: AI에 Creator 할당 요청

        return ticketRepository.save(initTicket).getId();
    }



}
