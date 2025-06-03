package com.capston_design.fkiller.itoms.ticket_core.controller;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignmentCallbackDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.completeTaskRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.completeTicketRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/ticket-core/callback")
@RequiredArgsConstructor
public class TicketCallbackController
{
    private final TicketService ticketService;

    @PostMapping("/v1/assign-handler")
    public ResponseEntity<Void> handleAssigneeUpdate(@RequestBody AssignmentCallbackDTO dto) {
        ticketService.assignHandler(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/task/{taskId}/complete")
    public ResponseEntity<Void> loggingTaskStatusUpdate(@PathVariable UUID taskId, @RequestBody completeTaskRequestDTO request) {
        log.info("[태스크 완료 요청] - taskId={}, ticketId={}, taskName={}, taskNowStatus={}, [request time] - {}", request.getTicketId(),
                taskId, request.getTaskName(), request.getTaskStatus(), request.getCompletionTime());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/v1/ticket/complete")
    public ResponseEntity<Void> completeTicket(@RequestBody completeTicketRequestDTO request) {
        ticketService.updateTicketStatus(request);
        return ResponseEntity.noContent().build();
    }
}
