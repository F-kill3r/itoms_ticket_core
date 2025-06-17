package com.capston_design.fkiller.itoms.ticket_core.service.event;

import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.CreateTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.CreateTicketResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class TicketKafkaListener {

    private final TicketService ticketService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.ticket.response:itoms.ticket.response}")
    private String ticketResponseTopic;

    @KafkaListener(topics = "#{'${kafka.topic.ticket.request:itoms.ticket.request}'}",
            groupId = "${spring.kafka.consumer.group-id:itoms-ticket-core}")
    public void handleCreateTicket(CreateTicketRequestDTO request) {
        log.info("[Kafka] create ticket request received. incidentId={}", request.getIncidentId());
        UUID ticketId = ticketService.createTicket(request);
        CreateTicketResponseDTO response = new CreateTicketResponseDTO(ticketId, request.getIncidentId());
        kafkaTemplate.send(ticketResponseTopic, request.getIncidentId().toString(), response);
        log.info("[Kafka] create ticket response sent. incidentId={}, ticketId={}", request.getIncidentId(), ticketId);
    }
} 