package com.capston_design.fkiller.itoms.ticket_core.domain.entity;

import com.capston_design.fkiller.itoms.ticket_core.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TICKET")
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id")
    private UUID id;

    @Column(name = "incident_id", nullable = false)
    private String incidentId;

    @Column(name = "closed_at")
    private String closedAt;

    @Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    @Column(name = "ticket_plan_start_date")
    private LocalDateTime ticketPlanStartDate;

    @Column(name = "ticket_plan_end_date")
    private LocalDateTime ticketPlanEndDate;

    @Column(name = "ticket_plan_duration")
    private LocalDateTime ticketPlanDuration;

    @Column(name = "ticket_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @Column(name = "ticket_tatus_code", nullable = false)
    private int ticketStatusCode;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "ticket_content", columnDefinition = "TEXT")
    private String ticketContent;

    @Column(name = "ticket_active", nullable = false)
    private boolean ticketActive;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "requester_id", nullable = false)
    private String requesterId;

    @Column(name = "requester_name", nullable = false)
    private String requesterName;

    @Column(name = "acceptor_id")
    private String acceptorId;

    @Column(name = "acceptor_name")
    private String acceptorName;

    @Builder(toBuilder = true)
    public Ticket(String incidentId, String closedAt, LocalDateTime acceptedAt, LocalDateTime ticketPlanStartDate,
                  LocalDateTime ticketPlanEndDate, LocalDateTime ticketPlanDuration, TicketStatus ticketStatus,
                  int ticketStatusCode, String ticketName, String ticketContent, boolean ticketActive, String creatorId,
                  String creatorName, String requesterId, String requesterName, String acceptorId, String acceptorName) {

        this.incidentId = incidentId;
        this.closedAt = closedAt;
        this.acceptedAt = acceptedAt;
        this.ticketPlanStartDate = ticketPlanStartDate;
        this.ticketPlanEndDate = ticketPlanEndDate;
        this.ticketPlanDuration = ticketPlanDuration;
        this.ticketStatus = ticketStatus;
        this.ticketStatusCode = ticketStatusCode;
        this.ticketName = ticketName;
        this.ticketContent = ticketContent;
        this.ticketActive = ticketActive;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.acceptorId = acceptorId;
        this.acceptorName = acceptorName;
    }

    public static Ticket ofCreateBaseTicket(String incidentId, String requesterId, String requesterName,
                                            TicketStatus ticketStatus){
        return Ticket.builder()
                .incidentId(incidentId)
                .requesterId(requesterId)
                .requesterName(requesterName)
                .ticketStatus(ticketStatus)
                .ticketStatusCode(ticketStatus.getCode())
                .ticketActive(false)
                .build();
    }

    public void updateTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
        this.ticketStatusCode = ticketStatus.getCode();
    }
    public void updateCreator(String creatorId, String creatorName) {
        this.creatorId = creatorId;
        this.creatorName = creatorName;
    }
    public void updateAcceptor(String acceptorId, String acceptorName) {
        this.acceptorId = acceptorId;
        this.acceptorName = acceptorName;
    }
}
