package com.capston_design.fkiller.itoms.ticket_core.common.ticket_status.annotation;

import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateTicketStatus {
    TicketStatus ticketStatus();
    boolean taskNotification() default false;
}
