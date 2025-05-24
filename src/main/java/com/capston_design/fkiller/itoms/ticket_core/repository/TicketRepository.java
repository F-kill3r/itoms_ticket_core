package com.capston_design.fkiller.itoms.ticket_core.repository;

import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
