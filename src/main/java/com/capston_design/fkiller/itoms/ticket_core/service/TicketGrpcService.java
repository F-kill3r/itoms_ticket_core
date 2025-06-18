package com.capston_design.fkiller.itoms.ticket_core.service;

import com.capston_design.fkiller.itoms.ticket.TicketProto;
import com.capston_design.fkiller.itoms.ticket_core.infra.grpc.mapper.TicketGrpcMapper;
import com.capston_design.fkiller.itoms.ticket.TicketServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class TicketGrpcService extends TicketServiceGrpc.TicketServiceImplBase {

    private final TicketService ticketService;

    public TicketGrpcService(@Qualifier("grpc") TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void createTicket(TicketProto.CreateTicketRequest request,
                             StreamObserver<TicketProto.CreateTicketResponse> responseObserver) {
        UUID ticketId = ticketService.createTicket(TicketGrpcMapper.toCreateTicketRequestDTO(request));

        TicketProto.CreateTicketResponse response = TicketProto.CreateTicketResponse.newBuilder()
                .setTicketId(ticketId.toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void completeTicket(TicketProto.completeTicketRequest request, StreamObserver<Empty> responseObserver) {
        super.completeTicket(request, responseObserver);
    }
}
