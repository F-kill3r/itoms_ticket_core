package com.capston_design.fkiller.itoms.ticket_core.common.ticket_status.aspect;

import com.capston_design.fkiller.itoms.ticket_core.common.ticket_status.annotation.UpdateTicketStatus;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
@Component
public class UpdateTicketStatusAspect {

    private static final ThreadLocal<TicketStatus> statusHolder = new ThreadLocal<>();

    @Before("@annotation(updateTicketStatus)")
    public void beforeMethod(UpdateTicketStatus updateTicketStatus) {
        statusHolder.set(updateTicketStatus.ticketStatus());
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {
                statusHolder.remove();
            }
        });
    }

    public static TicketStatus getStatus() {
        return statusHolder.get();
    }


}
