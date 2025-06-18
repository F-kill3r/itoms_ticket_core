package com.capston_design.fkiller.itoms.ticket_core.infra.grpc.mapper;

import com.capston_design.fkiller.itoms.ticket.TicketProto;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.RequesterDTO;

import java.util.UUID;

public class TicketGrpcMapper {

    public static CreateTicketRequestDTO toCreateTicketRequestDTO(TicketProto.CreateTicketRequest request) {
        return new CreateTicketRequestDTO(
                UUID.fromString(request.getIncidentId()),
                new RequesterDTO(
                        request.getRequesterId(),
                        request.getRequesterName()
                )
        );
    }
}
