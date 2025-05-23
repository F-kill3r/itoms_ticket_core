package com.capston_design.fkiller.itoms.ticket_core.entity;

import com.capston_design.fkiller.itoms.ticket_core.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TICKET")
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "incident_id", nullable = false)
    private String incidentId;

    @Column(name = "closed_at")
    private String closedAt;

    @Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    @Column(name = "plan_start_date")
    private LocalDateTime planStartDate;

    @Column(name = "plan_end_date")
    private LocalDateTime planEndDate;

    @Column(name = "plan_duration")
    private LocalDateTime planDuration;

    @Column(name = "ticket_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @Column(name = "status_code", nullable = false)
    private int statusCode;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "ticket_content", columnDefinition = "TEXT")
    private String ticketContent;

    @Column(name = "ticket_active")
    private boolean ticketActive;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "requester_id")
    private Long requesterId;

    @Column(name = "requester_name")
    private String requesterName;

    @Column(name = "acceptor_id")
    private Long acceptorId;

    @Column(name = "acceptor_name")
    private String acceptorName;

    //TODO - 티켓 클래스 생성 방식

}
