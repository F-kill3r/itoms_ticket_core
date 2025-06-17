package com.capston_design.fkiller.itoms.ticket_core.service.event;

import com.capston_design.fkiller.itoms.ticket_core.client.dto.TicketCompletedRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.dto.error.TicketCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaTicketEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.ticket.completed:itoms.ticket.completed}")
    private String ticketCompletedTopic;

    @Async
    @EventListener
    public void handleTicketCompletedEvent(TicketCompletedEvent event) {
        TicketCompletedRequestDTO dto = new TicketCompletedRequestDTO(event.getTicketId(), event.getIncidentId());
        kafkaTemplate.send(ticketCompletedTopic, event.getIncidentId().toString(), dto);
        log.info("[Kafka] ticket completed event published. incidentId={}, ticketId={}", event.getIncidentId(), event.getTicketId());
    }
} 