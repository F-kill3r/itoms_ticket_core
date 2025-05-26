package com.capston_design.fkiller.itoms.ticket_core.domain.entity;


import com.capston_design.fkiller.itoms.ticket_core.common.ticket_status.annotation.aspect.UpdateTicketStatusAspect;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TicketEntityListener {

    @PrePersist
    @PreUpdate
    public void beforeSave(Ticket ticket) {
        TicketStatus status = UpdateTicketStatusAspect.getStatus();
        if (status != null) {
            ticket.updateTicketStatus(status);
        }
    }
}
