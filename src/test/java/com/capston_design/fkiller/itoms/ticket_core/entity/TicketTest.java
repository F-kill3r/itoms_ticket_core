package com.capston_design.fkiller.itoms.ticket_core.entity;

import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void 초기화_티켓_생성() {
        String incident_id = "test_incident_id";
        String requester_id = "test_requester_id";
        String requester_name = "test_requester_name";
        TicketStatus ticketStatus = TicketStatus.REQUEST_CREATE_TICKET;
        Ticket baseTicket = Ticket.ofCreateBaseTicket(incident_id, requester_id,requester_name,ticketStatus);

        System.out.println("baseTicket.toString() = " + baseTicket.toString());

        assertEquals("test_incident_id", baseTicket.getIncidentId());
        assertEquals("test_requester_id", baseTicket.getRequesterId());
        assertEquals("test_requester_name", baseTicket.getRequesterName());
        assertEquals(1, baseTicket.getTicketStatusCode());
        assertEquals(TicketStatus.REQUEST_CREATE_TICKET, baseTicket.getTicketStatus());
        assertNull(baseTicket.getCreatorId());
        assertNull(baseTicket.getCreatorName());

        Ticket addedCreatorInfoTicket = baseTicket.toBuilder()
                .creatorId("test_creator_id")
                .creatorName("Fkiller").build();

        System.out.println("addedCreatorInfoTicket.toString() = " + addedCreatorInfoTicket.toString());

        assertEquals("test_creator_id", addedCreatorInfoTicket.getCreatorId());
        assertEquals("Fkiller", addedCreatorInfoTicket.getCreatorName());
    }

}