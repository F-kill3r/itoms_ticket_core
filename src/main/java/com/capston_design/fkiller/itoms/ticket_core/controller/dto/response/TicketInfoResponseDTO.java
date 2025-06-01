package com.capston_design.fkiller.itoms.ticket_core.controller.dto.response;

import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketInfoResponseDTO {
    private UUID incidentId;
    private UUID ticketId;
    private String creatorId;
    private String creatorName;
    private String acceptorId;
    private String acceptorName;
    private LocalDateTime ticketPlanStartDate;
    private LocalDateTime ticketPlanDuration;
    private String ticketName;
    private String ticketContent;
    private TicketStatus ticketStatus;

    public static TicketInfoResponseDTO from(Ticket ticket) {
        return TicketInfoResponseDTO.builder()
                .incidentId(ticket.getIncidentId())
                .ticketId(ticket.getId())
                .creatorId(ticket.getCreatorId())
                .creatorName(ticket.getCreatorName())
                .acceptorId(ticket.getAcceptorId())
                .acceptorName(ticket.getAcceptorName())
                .ticketPlanStartDate(ticket.getTicketPlanStartDate())
                .ticketPlanDuration(ticket.getTicketPlanDuration())
                .ticketName(ticket.getTicketName())
                .ticketContent(ticket.getTicketContent())
                .ticketStatus(ticket.getTicketStatus())
                .build();
    }
}
