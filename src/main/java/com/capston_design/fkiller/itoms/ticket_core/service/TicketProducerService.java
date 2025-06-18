package com.capston_design.fkiller.itoms.ticket_core.service;

import com.capston_design.fkiller.itoms.ticket_core.infra.kafka.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketProducerService {

    private final KafkaTemplate<Integer, TicketDTO> kafkaTemplate;

    public void sendTask(TicketDTO ticketDTO) {
        kafkaTemplate.send("ticket-topic", ticketDTO);
    }

}
